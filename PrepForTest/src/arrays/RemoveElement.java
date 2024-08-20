package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int [] nums = {3,2,2,3};
        int[] nums = {2};

        new RemoveElement().removeElement(nums, 3);
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int rightEdge = nums.length - 1;
        int leftEdge = 0;
        while (leftEdge <= rightEdge) {
            if (nums[leftEdge] == val) {
                while (leftEdge < rightEdge && nums[rightEdge] == val)
                    rightEdge--;
                nums[leftEdge] = nums[rightEdge];
                rightEdge--;
            }
            leftEdge++;
        }
        return rightEdge + 1;
    }
}
