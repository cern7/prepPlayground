package dynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        new EditDistance().minDistance("horse", "ros");
    }

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        }

        if (word1.equals(word2)) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i < m + 1; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 0; i < n + 1; i++) {
//            dp[0][i] = i;
//        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(
                            Math.min(dp[i - 1][j - 1], // replace
                                    dp[i][j - 1]),     // insertion
                            dp[i - 1][j]);             // deletion
                    dp[i][j] = 1 + min;
                }
            }
        }
        return dp[m][n];
    }
}
