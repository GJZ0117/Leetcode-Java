package medium;

/**
 * 861. Score After Flipping Matrix
 */

public class Score_After_Flipping_Matrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                count += grid[i][j];
            }
            ans += Math.max(count, m - count) * ((int) Math.pow(2, n - j - 1));
        }
        return ans;
    }
}
