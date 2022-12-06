package medium;

/**
 * 375. Guess Number Higher or Lower II
 */

public class Guess_Number_Higher_or_Lower_II {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getMoneyAmount(n));
    }

    /**
     * eg: n = 5
     * [0 0 0 0 0 0]    [0 0 0 0 0 0]   [0 0 0 0 0 0]   [0 0 0 0 0 0]   [0 0 0 0 0 0]
     * [0 0 0 0 0 0]    [0 0 1 0 0 0]   [0 0 1 2 0 0]   [0 0 1 2 4 0]   [0 0 1 2 4 6]
     * [0 0 0 0 0 0]    [0 0 0 2 0 0]   [0 0 0 2 3 0]   [0 0 0 2 3 6]   [0 0 0 2 3 6]
     * [0 0 0 0 0 0] -> [0 0 0 0 3 0] ->[0 0 0 0 3 4] ->[0 0 0 0 3 4] ->[0 0 0 0 3 4]
     * [0 0 0 0 0 0]    [0 0 0 0 0 4]   [0 0 0 0 0 4]   [0 0 0 0 0 4]   [0 0 0 0 0 4]
     * [0 0 0 0 0 0]    [0 0 0 0 0 0]   [0 0 0 0 0 0]   [0 0 0 0 0 0]   [0 0 0 0 0 0]
     */

    //https://leetcode.cn/problems/guess-number-higher-or-lower-ii/solution/xiang-xi-fen-xi-cong-di-gui-dao-ji-yi-hu-9qun/
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        // loop n times
        for (int k = 1; k <= n; k++) {
            int i = 1;
            int j = k;
            // every look i + 1 and j + 1, which means [i,j] move to its right down side (eg:[0,0]->[1,1]->[2,2]...)
            while (j <= n) {
                // if j - i <= 2 we can get the answer directly
                if (i == j) {
                    dp[i][j] = 0;
                } else if (j - i <= 1) {
                    dp[i][j] = i;
                } else if (j - i <= 2) {
                    dp[i][j] = i + 1;
                } else {
                    // if j - i > 2, calculate according to these rules:
                    // 1.if the correct num is smaller than x, we need to pay x + dp[i][x-1]
                    // 2.if the correct num is larger than x, we need to pay x + dp[x+1][j]
                    // 3.if the correct num equals to x, pay 0
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = i + 1; x < j; x++) {
                        dp[i][j] = Math.min(dp[i][j], x + Math.max(dp[i][x - 1], dp[x + 1][j]));
                    }
                }
                i++;
                j++;
            }
        }
        return dp[1][n];
    }
}
