package arrays;

import java.util.Arrays;

public class DifferenceBetweenElementSumAndDigitSum {
    public static void main(String[] args) {
        new DifferenceBetweenElementSumAndDigitSum()
                .differenceOfSum(new int[]{1, 15, 6, 3});
    }

    public int differenceOfSum(int[] nums) {
        int elementSum = Arrays.stream(nums).sum();
        int digitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            digitSum += digitSum(nums[i]);
        }
        return Math.abs(elementSum - digitSum);
    }

    private int digitSum(int x) {
        if (x < 10) {
            return x;
        }
        int res = 0;
        while (x > 9) {
            int i = x % 10;
            res += i;
            x /= 10;
        }
        return res + x;
    }
}
