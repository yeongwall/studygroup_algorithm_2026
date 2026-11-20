import java.util.Scanner;
public class Segment_Update {
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

    public static void Update(int oid, long amt, int index, int start, int end) {
        if (oid < start || oid > end) return;
        long before = stree[index];
        stree[index] += amt;
        System.out.println("[" + start + "," + end + "] " + before + " -> " + stree[index]);
        if (start != end) {
            Update(oid, amt, index * 2 + 1, start, (start + end) / 2);
            Update(oid, amt, index * 2 + 2, (start + end) / 2 + 1, end);
        }
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
            int i = sc.nextInt();
            long d = sc.nextLong();
            Update(i, d, 0, 0, n - 1);
        }
    }
}