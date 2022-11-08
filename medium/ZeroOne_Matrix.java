package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 542. 01 Matrix
 */

public class ZeroOne_Matrix {
    //BFS
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];

            if (i > 0 && mat[i - 1][j] == -1) { // up
                mat[i - 1][j] = mat[i][j] + 1;
                queue.add(new int[]{i - 1, j});
            }
            if (i < m - 1 && mat[i + 1][j] == -1) { // down
                mat[i + 1][j] = mat[i][j] + 1;
                queue.add(new int[]{i + 1, j});
            }
            if (j > 0 && mat[i][j - 1] == -1) { // left
                mat[i][j - 1] = mat[i][j] + 1;
                queue.add(new int[]{i, j - 1});
            }
            if (j < n - 1 && mat[i][j + 1] == -1) { // right
                mat[i][j + 1] = mat[i][j] + 1;
                queue.add(new int[]{i, j + 1});
            }
        }
        return mat;
    }
}
