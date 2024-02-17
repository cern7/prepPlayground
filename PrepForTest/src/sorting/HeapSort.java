package sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = {84,22,19,17,10,9,6,5,3};
        new HeapSort().heapSort(a);
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
        return i << 1;
    }

    private int right(int i) {
        return (i << 1) + 1;
    }

    private void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
