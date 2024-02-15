package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        sort(new int[]{12, 31, 25, 8, 32, 17});
    }

    public static void sort(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i] = arr[i] + arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] = arr[i] - arr[i + 1];
                    swapped = true;
                }
            }
        }
    }
}
