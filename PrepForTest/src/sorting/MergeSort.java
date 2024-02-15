package sorting;

public class MergeSort {
    public static void main(String[] args) {
        new MergeSort().mergeSort(new int[]{4, 2, 1, 5, 9, 8});
    }

    public void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            // sort left half
            mergeSort(array, helper, low, mid);
            // sort right half
            mergeSort(array, helper, mid + 1, high);
            // merge back
            merge(array, helper, low, mid, high);
        }
    }

    public void merge(int[] array, int[] helper, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int curr = low;
        // iterate through helper array.
        // compare left and right half, copying back the smaller element form the two halves
        // into the original array
        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[curr] = helper[helperLeft];
                helperLeft++;
            } else { // if the right element is smaller than left element
                array[curr] = helper[helperRight];
                helperRight++;
            }
            curr++;
        }

        int remaining = mid - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[curr + i] = helper[helperLeft + i];
        }
    }

}
