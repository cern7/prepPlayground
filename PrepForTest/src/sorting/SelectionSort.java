package sorting;
import java.util.ArrayList;
public class SelectionSort {
    public static void main(String[] args) {
        sort(new int[]{12, 31, 25, 8, 32, 17});
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = min(arr, i, arr.length);
            arr[i] = arr[i] + arr[min];
            arr[min] = arr[i] - arr[min];
            arr[i] = arr[i] - arr[min];
        }
    }

    private static int min(int[] arr, int start, int end) {
        int min = arr.length - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }
}
