package hard;

/**
 * 85. Maximal Rectangle
 */

public class Maximal_Rectangle {

    /**
     * matrix:
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * step 1 : find each position's continuous 1 number from up to down
     * dp array :
     * 1 0 1 0 0
     * 2 0 2 1 1
     * 3 1 3 2 2
     * 4 0 0 3 0
     *
     * step 2 : at each position, count the number which is over or equals to the position's number on both left side and right side
     * count array :
     * 1 0 1 0 0
     * 1 0 1 3 3
     * 1 5 1 3 3
     * 1 0 0 1 0
     *
     * step 4 : rectangle area = dp[i][j] * count[i][j]
     */

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    int count = 1;
                    for (int k = j - 1; k >= 0 && dp[i][k] >= dp[i][j]; k--) {
                        count++;
                    }
                    for (int k = j + 1; k < n && dp[i][k] >= dp[i][j]; k++) {
                        count++;
                    }
                    maxArea = Math.max(maxArea, count * dp[i][j]);
                }
            }
        }
        return maxArea;
    }
}
