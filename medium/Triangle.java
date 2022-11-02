package medium;

import java.util.List;

/**
 * 120. Triangle
 */

public class Triangle {

    /**
     * d(i,j) = min(dp(i-1,j-1), dp(i-1,j)) + triangle(i,j)
     * eg:
     * triangle:
     * [2]
     * [3, 4]
     * [6, 5, 7]
     * [4, 1, 8, 3]
     *
     * dp:
     * 2
     * 5    6
     * 11   10  11
     * 15   11  18  14
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }
}
