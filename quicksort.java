import java.util.Scanner;

public class quicksort {

    static void quick(int[] b, int s, int e) {
        if (s >= e) return;
            int pivot = b[s];
        int i = s, j = e;
        while (i <= j) {
            while (b[i] < pivot) i++;
            while (b[j] > pivot) j--;
            if (i <= j) {
                int tmp = b[i]; b[i] = b[j]; b[j] = tmp;
                i++;
                j--;
            }
        }
        quick(b, s, j);
        quick(b, i, e);
    }

    static void qsort(int[] b) {
        quick(b, 0, b.length - 1);
    }

    static void ShowArr(int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(b[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        qsort(b);
        ShowArr(b);
    }
}