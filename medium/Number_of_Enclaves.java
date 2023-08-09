package medium;

/**
 * 1020. Number of Enclaves
 */

public class Number_of_Enclaves {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, m, n);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1, m, n);
            }
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, m, n);
            }
            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j, m, n);
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            for (int[] direction : directions) {
                dfs(grid, i + direction[0], j + direction[1], m, n);
            }
        }
    }
}
