package leetCodePrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[1000000001];
        for (int i = 0; i < nums.length; i++) {
            if (arr[target - nums[i]] == 0) {
                arr[nums[i]] = i + 1;
            } else {
                return new int[]{i, arr[target - nums[i]] - 1};
            }
        }
        System.gc();
        return null;
    }
}
