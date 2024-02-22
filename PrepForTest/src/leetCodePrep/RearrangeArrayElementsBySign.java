package leetCodePrep;

import org.w3c.dom.ls.LSOutput;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {

        int[] a = {-1,1};
        new RearrangeArrayElementsBySign().rearrangeArray(a);
    }

    public int[] rearrangeArray(int[] nums) {

        int size = nums.length;
        int[] p = new int[size / 2];
        int[] n = new int[size / 2];
        int pI = 0;
        int nI = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] < 0) {
                n[nI++] = nums[i];
            } else {
                p[pI++] = nums[i];
            }
        }

        pI = 0;
        nI = 0;

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                nums[i] = p[pI++];
            } else {
                nums[i] = n[nI++];
            }
        }
        return nums;
    }

    private void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
