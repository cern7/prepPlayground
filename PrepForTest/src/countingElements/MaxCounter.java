package countingElements;

import java.util.Arrays;

public class MaxCounter {
    public static void main(String[] args) {
        print(solution(1, new int[]{2, 1, 1, 2, 1}));
    }

    public static int[] solution(int N, int[] A) {
        int maxCounterValue = 0;
        int[] result = new int[N];

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                result[A[i] - 1]++;
                maxCounterValue = Math.max(maxCounterValue, result[A[i] - 1]);
            }
            if (A[i] == N + 1) {
                Arrays.fill(result, maxCounterValue);
            }
        }
        return result;
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
