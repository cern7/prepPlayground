import java.util.Arrays;

public class LongestIncresingSubsequence {
    public static void main(String[] args) {
//        System.out.println(dpBinarySearchNlogN(new int[]{15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3}));
        System.out.println(dpBinarySearchNlogN(new int[]{1,5}));
    }


    public static int dpBinarySearchNlogN(int[] arr) {
        /*
         * will use dynamic programming array d[0...n]
         * d[s] doesn't correspond to the element a[i]
         * or to a prefix of the array.
         * d[s] will be the smallest element at which an
         * increasing subsequence of length s ends.
         * What is the conditions to write the current a[i] into d[0...n] array?
         *  - d[s] = a[i] if there is longest increasing sequence of length s
         * that ends in a[i], and there is no longest increasing sequence of length s
         * that ends in a smaller number
         * There is the longest increasing sequence of length s - 1 that can be extended
         * with number a[i], if d[s - 1] < a[i] ==> can just iterate over each length s,
         * and check if we can extend the longest increasing sequence of length s - 1
         * also check if we already found the longest increasing sequence of length s
         * with smaller number at the end a[i] < d[s]
         */

        int n = arr.length;
        final int INF = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = -INF;

        for (int i = 0; i < n; i++) {
            int s = Arrays.binarySearch(dp, arr[i]);
            s = s < 0 ? Math.abs(s) - 1 : s;
            if (dp[s - 1] < arr[i] && arr[i] < dp[s]) {
                dp[s] = arr[i];
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] < INF)
                ans = i;
        }
        return ans;

    }

    public static int dpOn2(int[] arr) {
        /*
         * First search for the length of the longest increasing
         * subsequence.
         * Will define an array d[0...n-1] where d[i] is the length
         * of the longest increasing subsequence that ends in the element
         * at index i
         * - d[i] = 1 the required subsequence consists ony of the element a[i]
         * - d[i] > 1 the subsequence will end at a[i] and right before it
         * will be some number a[j], j < i && a[j] < a[i]
         */
        int size = arr.length;
        int[] d = new int[size];
        Arrays.fill(d, 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        int ans = d[0];
        for (int i = 1; i < size; i++) {
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }
}
