package medium;

import java.util.Arrays;

/**
 * 322. Coin Change
 */

public class Coin_Change {

    public static void main(String[] args) {
        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int amount = 9864;
        System.out.println(coinChange(coins, amount));
    }

    // https://leetcode.cn/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    // Time Limit Exceeded
    public static int _coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        // reverse
        int i = 0;
        int j = coins.length - 1;
        while (i < j) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
            i++;
            j--;
        }
        int[] ans = {Integer.MAX_VALUE};
        search(coins, amount, 0, 0, ans);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    public static void search(int[] coins, int remain, int start, int count, int[] ans) {
        if (remain == 0) {
            ans[0] = Math.min(ans[0], count);
            return;
        }
        if (start == coins.length) {
            return;
        }
        for (int i = remain / coins[start]; i >= 0 && i + count < ans[0]; i--) {
            search(coins, remain - i * coins[start], start + 1, i + count, ans);
        }
    }


    // 二刷（还不会）
    // https://leetcode.cn/problems/coin-change/solutions/6568/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
    public int coinChange_2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}
