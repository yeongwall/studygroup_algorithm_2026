import java.util.Scanner;

public class Segment {
    static long[] A;
    static long[] stree;

    public static long Build(int index, int start, int end) {
        if (start == end) stree[index] = A[start];
        else
            stree[index] = Build(index * 2 + 1, start, (start + end) / 2)
                         + Build(index * 2 + 2, (start + end) / 2 + 1, end);
        return stree[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = new long[n];
        stree = new long[2 * n - 1];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Build(0, 0, n - 1);

        for (int i = 0; i < 2 * n - 1; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(stree[i]);
        }
        System.out.println();
    }
}