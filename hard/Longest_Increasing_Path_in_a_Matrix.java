package hard;

import java.util.Arrays;

/**
 * 329. Longest Increasing Path in a Matrix
 */

public class Longest_Increasing_Path_in_a_Matrix {
    public int longestIncreasingPath(int[][] matrix) {
        int longestPath = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curPath = searchPath(matrix, dp, i, j, m, n);
                longestPath = Math.max(longestPath, curPath);
            }
        }
        return longestPath;
    }

    public int searchPath(int[][] matrix, int[][] dp, int i, int j, int m, int n) {
        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) { // up
            if (dp[i - 1][j] != -1) {
                up = dp[i - 1][j] + 1;
            } else {
                up = searchPath(matrix, dp, i - 1, j, m, n) + 1;
            }
        }
        if (i < m - 1 && matrix[i + 1][j] > matrix[i][j]) { // down
            if (dp[i + 1][j] != -1) {
                down = dp[i + 1][j] + 1;
            } else {
                down = searchPath(matrix, dp, i + 1, j, m, n) + 1;
            }
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) { // left
            if (dp[i][j - 1] != -1) {
                left = dp[i][j - 1] + 1;
            } else {
                left = searchPath(matrix, dp, i, j - 1, m, n) + 1;
            }
        }
        if (j < n - 1 && matrix[i][j + 1] > matrix[i][j]) { // right
            if (dp[i][j + 1] != -1) {
                right = dp[i][j + 1] + 1;
            } else {
                right = searchPath(matrix, dp, i, j + 1, m, n) + 1;
            }
        }

        int longestPath = Math.max(up, Math.max(down, Math.max(left, right)));
        dp[i][j] = longestPath;
        return longestPath;
    }
}
