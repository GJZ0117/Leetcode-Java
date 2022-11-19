package medium;

/**
 * 174. Dungeon Game
 */

public class Dungeon_Game {
    //https://leetcode.cn/problems/dungeon-game/solution/yan-ge-zheng-ming-dong-tai-gui-hua-yi-ji-wei-shi-y/
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minNeed = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minNeed - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
