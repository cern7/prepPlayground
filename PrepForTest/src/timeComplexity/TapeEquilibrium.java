package timeComplexity;

import java.util.Arrays;

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 3};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int size = A.length;
        int sum = Arrays.stream(A).sum();

        int minDiff = 0;
        int part1 = A[0];
        int part2 = sum - part1;
        minDiff = Math.abs(part1 - part2);
        for (int i = 1; i < size - 1; i++) {
            part1 += A[i];
            part2 = sum - part1;
            int tempDiff = Math.abs(part1 - part2);
            minDiff = Math.min(minDiff, tempDiff);
        }
        return minDiff;
    }
}
