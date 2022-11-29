package easy;

/**
 * 463. Island Perimeter
 */

public class Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = {0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    search(grid, i, j, m, n, ans);
                    return ans[0];
                }
            }
        }
        return ans[0];
    }

    public void search(int[][] grid, int i, int j, int m, int n, int[] ans) {
        grid[i][j] = -1;
        if (i == 0 || grid[i - 1][j] == 0) { // up
            ans[0]++;
        }
        if (i == m - 1 || grid[i + 1][j] == 0) { // down
            ans[0]++;
        }
        if (j == 0 || grid[i][j - 1] == 0) { // left
            ans[0]++;
        }
        if (j == n - 1 || grid[i][j + 1] == 0) { // right
            ans[0]++;
        }

        if (i > 0 && grid[i - 1][j] == 1) { // up
            search(grid, i - 1, j, m, n, ans);
        }
        if (i < m - 1 && grid[i + 1][j] == 1) { // down
            search(grid, i + 1, j, m, n, ans);
        }
        if (j > 0 && grid[i][j - 1] == 1) { // left
            search(grid, i, j - 1, m, n, ans);
        }
        if (j < n - 1 && grid[i][j + 1] == 1) { // right
            search(grid, i, j + 1, m, n, ans);
        }
    }
}
