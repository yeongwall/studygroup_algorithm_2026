import java.util.Scanner;
public class Segment_Query {
    static long[] A;
    static long[] stree;

    public static long Build(int index, int start, int end) {
        if (start == end)
            stree[index] = A[start];
        else
            stree[index] = Build(index * 2 + 1, start, (start + end) / 2)
                         + Build(index * 2 + 2, (start + end) / 2 + 1, end);
        return stree[index];
    }

    public static long Sum(int left, int right, int index, int start, int end) {
        if (left > end || right < start) return 0;
        if (start >= left && end <= right) {
            System.out.println("[" + start + "," + end + "] " + stree[index]);
            return stree[index];
        }
        return Sum(left, right, index * 2 + 1, start, (start + end) / 2)
             + Sum(left, right, index * 2 + 2, (start + end) / 2 + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = new long[n];
        stree = new long[4 * n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Build(0, 0, n - 1);

        int q = sc.nextInt();
        for (int k = 0; k < q; k++) {
            sc.next();
            int left = sc.nextInt();
            int right = sc.nextInt();
            System.out.println("TOTAL " + Sum(left, right, 0, 0, n - 1));
        }
    }
}