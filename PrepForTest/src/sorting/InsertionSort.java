package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        sort(new int[]{12, 31, 25, 8, 32, 17});
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }
}
