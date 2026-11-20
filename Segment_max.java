import java.util.Scanner;
public class Segment_max {
    static long[] A;
    static long[] stree1;

    public static long Build1(int index, int start, int end) {
        if (start == end) stree1[index] = A[start];
        else {
            long t1 = Build1(index * 2 + 1, start, (start + end) / 2);
            long t2 = Build1(index * 2 + 2, (start + end) / 2 + 1, end);
            stree1[index] = Math.max(t1, t2);
        }
        return stree1[index];
    }

    public static long Sum1(int left, int right, int sid, int start, int end) {
        long res;
        if (left > end || right < start) res = -1000000000;
        else if (start >= left && end <= right) res = stree1[sid];
        else {
            long t1 = Sum1(left, right, sid * 2 + 1, start, (start + end) / 2);
            long t2 = Sum1(left, right, sid * 2 + 2, (start + end) / 2 + 1, end);
            res = Math.max(t1, t2);
        }
        return (res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = new long[n];
        stree1 = new long[4 * n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Build1(0, 0, n - 1);

        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(Sum1(left, right, 0, 0, n - 1));
    }
}
