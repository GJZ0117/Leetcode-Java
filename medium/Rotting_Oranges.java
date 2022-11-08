package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 */

public class Rotting_Oranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;

        for (int i = 0; i < m; i++) { // add all rotted oranges' ppositions into queue
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    ans = 0;
                } else if (grid[i][j] == 1) {
                    flag = true;
                }
            }
        }

        if (ans == -1 && !flag) { // if there's no rotted orange and no fresh orange return 0
            return 0;
        } else if (ans == -1 && flag) { // if there's no rotted orange but have fresh orange return -1
            return -1;
        }

        while (!queue.isEmpty()) { // BFS
            int size = queue.size();
            while (size > 0) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];

                if (i > 0 && grid[i - 1][j] == 1) { // up
                    grid[i - 1][j] = 2;
                    queue.add(new int[]{i - 1, j});
                }
                if (i < m - 1 && grid[i + 1][j] == 1) { // down
                    grid[i + 1][j] = 2;
                    queue.add(new int[]{i + 1, j});
                }
                if (j > 0 && grid[i][j - 1] == 1) { // left
                    grid[i][j - 1] = 2;
                    queue.add(new int[]{i, j - 1});
                }
                if (j < n - 1 && grid[i][j + 1] == 1) { // right
                    grid[i][j + 1] = 2;
                    queue.add(new int[]{i, j + 1});
                }
                size--;
            }
            ans++;
        }
        ans--; // the answer has one more loop

        for (int i = 0; i < m; i++) { // remain fresh orange which can not reach, return -1
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
