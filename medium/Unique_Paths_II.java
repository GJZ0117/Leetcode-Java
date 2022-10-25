package medium;

/**
 * 63. Unique Paths II
 */

public class Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean obstacleFlag = false;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (!obstacleFlag && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
                obstacleFlag = true;
            }
        }

        obstacleFlag = false;
        for (int j = 0; j < n; j++) {
            if (!obstacleFlag && obstacleGrid[0][j] == 0){
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
                obstacleFlag = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
