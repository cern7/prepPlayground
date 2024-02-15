package sorting;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2, 5, 1, 8, 20}));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 2] - A[i + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
