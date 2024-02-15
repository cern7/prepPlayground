package sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main(String[] args) {
//        int[] a = {1000, 1000, 1, 1000, 23, 3213};
        int[] a = {-3, 1, 2, -2, 5, 6};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int s = A.length;
        int maxProd = A[s - 1] * A[s - 2] * A[s - 3];
        int minProd = A[0] * A[1] * A[s - 1];
        return Math.max(maxProd, minProd);
    }
}
