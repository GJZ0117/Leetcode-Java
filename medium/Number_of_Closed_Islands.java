package medium;

/**
 * 1254. Number of Closed Islands
 */

public class Number_of_Closed_Islands {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m, n)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean dfs(int[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        return dfs(grid, x + 1, y, m, n)
                & dfs(grid, x - 1, y, m, n)
                & dfs(grid, x, y + 1, m, n)
                & dfs(grid, x, y - 1, m, n);
    }
}
