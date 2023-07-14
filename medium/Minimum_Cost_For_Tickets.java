package medium;

/**
 * 983. Minimum Cost For Tickets
 */

public class Minimum_Cost_For_Tickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];
        int index = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i == days[index]) {
                dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
