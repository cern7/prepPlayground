package sorting;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

public class QuickSort {
    private Random random = new Random();

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 16, 3, 12, 10, 4};

        new QuickSort().randomizedQuicksort(arr, 0, arr.length - 1);

    }

    private void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }

    }

    private int partition(int[] A, int p, int r) {
        // select an element x = A[r] as a pivot element
        // around which to partition the sub-array
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                exchange(A, i, j);
            }
        }
        exchange(A, i + 1, r);
        return i + 1;
    }

    private int randomizedPartition(int[] A, int p, int r) {
        int i = random.nextInt(p, r + 1);
//        int i = (int) (Math.random() * (r - p) + p);
        exchange(A, r, i);
        return partition(A, p, r);
    }

    public void randomizedQuicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(A, p, r);
            randomizedQuicksort(A, p, q - 1);
            randomizedQuicksort(A, q + 1, r);
        }
    }

    private void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
