package sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
//        int[] a = {84, 22, 19, 17, 10, 9, 6, 5, 3};
//        new HeapSort().heapSort(a);
        int[] b = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
//        new HeapSort().heapExtractMax(b, 12);
        new HeapSort().maxHeapInsert(b, 10, 12);

    }

    private void maxHeapInsert(int[] A, int key, int heapSize) {
        heapSize++;
        if (heapSize >= A.length) {
            A = Arrays.copyOf(A, 2 * A.length);
        }
        A[heapSize] = Integer.MIN_VALUE;
        heapIncreaseKey(A, heapSize, key);
    }

    private int heapMaximum(int[] A) {
        return A[0];
    }

    private int heapExtractMax(int[] A, int heapSize) {
        if (heapSize < 1) {
            throw new IndexOutOfBoundsException("Heap underflow");
        }
        int max = A[0];
        A[0] = A[heapSize - 1];
        if (heapSize < A.length / 2 - 1) {
            A = Arrays.copyOf(A, A.length / 2);
        }
        heapSize--;
        maxHeapify(A, 0, heapSize);
        return max;
    }

    private void heapIncreaseKey(int[] A, int i, int key) {
        if (key < A[i]) {
            throw new IllegalArgumentException("New key is smaller than current key");
        }
//        A[i] = key;
//        while (i > 0 && A[parent(i)] < A[i]) {
        while (i > 0 && A[parent(i)] < key) {
//            exchange(A, i, parent(i));
            A[i] = A[parent(i)];
            i = parent(i);
        }
        A[i] = key;
    }

    private void maxHeapify(int[] arr, int i, int heapSize) {
        boolean done = false;
        int largest = i;
        while (!done) {
            int l = left(i);
            int r = right(i);
            if (l < heapSize && arr[l] > arr[i]) {
                largest = l;
            }
            if (r < heapSize && arr[r] > arr[largest]) {
                largest = r;
            }
            if (largest != i) {
                exchange(arr, i, largest);
                i = largest;
            } else {
                done = true;
            }
        }
    }

    private int buildMaxHeap(int[] arr) {
        int res = arr.length;
        for (int i = arr.length / 2; i > -1; i--) {
            maxHeapify(arr, i, res);
        }
        return res;
    }

    public void heapSort(int[] A) {
        int heapSize = buildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {
            exchange(A, 0, i);
            heapSize--;
            maxHeapify(A, 0, heapSize);
        }
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i << 1) + 2;
    }

    private void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int parent(int i) {
        return (i - 1) >> 1;
    }
}
