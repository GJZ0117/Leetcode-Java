package hard;

/**
 * 980. Unique Paths III
 */

public class Unique_Paths_III {

    int count = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int start_x = 0;
        int start_y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                } else if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                    visited[i][j] = true;
                }
            }
        }
        return dfs(grid, visited, m, n, start_x, start_y, 0);
    }

    private int dfs(int[][] grid, boolean[][] visited, int m, int n, int i, int j, int cnt) {
        if (grid[i][j] == 2) {
            return cnt == count + 1 ? 1 : 0;
        }
        int ans = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] != -1) {
                visited[x][y] = true;
                ans += dfs(grid, visited, m, n, x, y, cnt + 1);
                visited[x][y] = false;
            }
        }
        return ans;
    }
}
