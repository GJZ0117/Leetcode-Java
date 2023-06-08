package medium;

/**
 * 931. Minimum Falling Path Sum
 */

public class Minimum_Falling_Path_Sum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
            dp[i][n - 1] = Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]) + matrix[i][n - 1];
            for (int j = 1; j < n - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (dp[n - 1][j] < res) {
                res = dp[n - 1][j];
            }
        }
        return res;
    }
}
