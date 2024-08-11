package medium;

/**
 * 1905. Count Sub Islands
 */

public class Count_Sub_Islands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    grid2[i][j] += grid1[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 2 && dfs(grid2, i, j, m, n)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean dfs(int[][] grid2, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return true;
        }
        if (grid2[x][y] != 2) {
            return grid2[x][y] == 0;
        }
        grid2[x][y] = 0;
        return dfs(grid2, x + 1, y, m, n)
                & dfs(grid2, x - 1, y, m, n)
                & dfs(grid2, x, y + 1, m, n)
                & dfs(grid2, x, y - 1, m, n);

    }
}
