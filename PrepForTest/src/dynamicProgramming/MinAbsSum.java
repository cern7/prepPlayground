package dynamicProgramming;

import java.util.Arrays;

public class MinAbsSum {
    static int[] dp;

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, -2};
        System.out.println(solution0(arr));
    }

    public static int solution0(int[] A) {
        int size = A.length;
        int maxElem = 0;
        for (int i = 0; i < size; i++) {
            A[i] = Math.abs(A[i]);
            maxElem = Math.max(A[i], maxElem);
        }
        int S = Arrays.stream(A).sum();
        int[] count = new int[maxElem + 1];
        dp = new int[S + 1];
        for (int i = 0; i < size; i++) {
            count[A[i]] += 1;
        }
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < maxElem + 1; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < S; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = count[i];
                    } else if (j >= i && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }
        int res = S;
        for (int i = 0; i < Math.floor(S / 2) + 1; i++) {
            if (dp[i] >= 0) {
                res = Math.min(res, S - 2 * i);
            }
        }
        return res;
    }


    public static int solution1(int[] A) {
        // Implement your solution here
        int size = A.length;
        int maxElem = 0;
        for (int i = 0; i < size; i++) {
            A[i] = Math.abs(A[i]);
            maxElem = Math.max(A[i], maxElem);
        }
        int S = Arrays.stream(A).sum();
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < size; i++) {
            for (int j = S; j >= 0; j--) {
                if (dp[i] == 1 && i + A[j] <= S) {
                    dp[i + A[j]] = 1;
                }
            }
        }
        int res = S;
        for (int i = 0; i < S / 2 + 1; i++) {
            if (dp[i] == 1) {
                res = Math.min(res, S - 2 * i);
            }
        }
        return res;
    }

}
