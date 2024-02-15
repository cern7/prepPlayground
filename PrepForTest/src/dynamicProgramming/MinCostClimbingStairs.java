package dynamicProgramming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(
                new MinCostClimbingStairs()
                        .minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 3) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length + 1];
        dp[cost.length] = 0;
        for (int i = cost.length - 1; i > -1; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1],
                    i + 2 < cost.length + 1 ? dp[i + 2] : 0);
        }
        return Math.min(dp[0], dp[1]);
    }
}
