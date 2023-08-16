package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1034. Coloring A Border
 */

public class Coloring_A_Border {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m = 0;
    int n = 0;
    int[][] res;
    Deque<int[]> deque = new ArrayDeque<>();
    Deque<int[]> removeDeque = new ArrayDeque<>();

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        res = new int[m][n];

        dfs(grid, row, col, grid[row][col], color);

        while (!deque.isEmpty()) {
            int[] pos = deque.poll();
            int i = pos[0];
            int j = pos[1];
            boolean flag = true;
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x < 0 || x >= m || y < 0 || y >= n || res[x][y] != color) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                removeDeque.add(pos);
            }
        }

        while (!removeDeque.isEmpty()) {
            int[] pos = removeDeque.poll();
            res[pos[0]][pos[1]] = grid[row][col];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0 || res[i][j] == -1) {
                    res[i][j] = grid[i][j];
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int target, int color) {
        if (res[i][j] != 0 || grid[i][j] != target) {
            return;
        }
        res[i][j] = color;
        deque.add(new int[]{i, j});
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (grid[x][y] == target) {
                dfs(grid, x, y, target, color);
            } else {
                res[x][y] = -1;
            }
        }
    }
}
