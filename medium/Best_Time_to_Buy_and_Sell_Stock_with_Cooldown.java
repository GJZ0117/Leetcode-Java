package medium;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; // does not hold stock, does not sell out today
        dp[0][1] = 0; // does not hold stock, sold out today
        dp[0][2] = -prices[0]; // hold stock, buy in today
        dp[0][3] = -prices[0]; // hold stock, buy in another day(not today)
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); // the maxium situation of holding stock or not on yesterday
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3]) + prices[i]; // sold the stock today, find the maxium profit situation of holding stock on yesterday
            dp[i][2] = dp[i - 1][0] - prices[i]; // buy in the stock today, it must not sell or buy stock yesterday
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]); // does not buy the stock today but holding stock, find maxium profit situation from yesterday's two holding situation
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
