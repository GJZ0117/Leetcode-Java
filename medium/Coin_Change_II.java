package medium;

/**
 * 518. Coin Change II
 */

public class Coin_Change_II {
    // https://leetcode.cn/problems/coin-change-ii/solution/ling-qian-dui-huan-ii-er-wei-zhuan-yi-we-4ywa/
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
