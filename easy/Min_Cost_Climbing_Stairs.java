package easy;

/**
 * 746. Min Cost Climbing Stairs
 */

public class Min_Cost_Climbing_Stairs {

    /**
     * https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
