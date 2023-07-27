package medium;

/**
 * 464. Can I Win
 */

public class Can_I_Win {
    // https://leetcode.cn/problems/can-i-win/solution/zhuang-tai-ya-suo-de-dong-tai-gui-hua-hui-su-bo-yi/
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger], 0);
    }

    public boolean dfs(int maxChoosableInteger, int desiredTotal, Boolean[] dp, int state) {
        if (dp[state] != null) {
            return dp[state];
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << (i - 1);
            if ((cur & state) != 0) {
                continue;
            }
            if (desiredTotal - i <= 0 || !dfs(maxChoosableInteger, desiredTotal - i, dp, state | cur)) {
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}
