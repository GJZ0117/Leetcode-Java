package medium;

/**
 * 576. Out of Boundary Paths
 */

public class Out_of_Boundary_Paths {
    int m;
    int n;
    int maxMove;
    int MOD = (int) 1e9 + 7;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] cache;

    // https://leetcode.cn/problems/out-of-boundary-paths/solution/gong-shui-san-xie-yi-ti-shuang-jie-ji-yi-asrz/
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        this.maxMove = maxMove;
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(startRow, startColumn, maxMove);
    }

    public int dfs(int x, int y, int maxMove) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (cache[x][y][maxMove] != -1) {
            return cache[x][y][maxMove];
        }
        int ans = 0;
        for (int[] dir : dirs) {
            int _x = x + dir[0];
            int _y = y + dir[1];
            ans += dfs(_x, _y, maxMove - 1);
            ans %= MOD;
        }
        cache[x][y][maxMove] = ans;
        return ans;
    }
}
