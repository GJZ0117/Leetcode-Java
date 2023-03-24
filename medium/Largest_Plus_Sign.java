package medium;

import java.util.Arrays;

/**
 * 764. Largest Plus Sign
 */

public class Largest_Plus_Sign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] graph = new int[n][n];
        for (int[] arr : graph) {
            Arrays.fill(arr, 1);
        }
        for (int[] mine : mines) {
            graph[mine[0]][mine[1]] = 0;
        }
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1;
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
                if (graph[n - i - 1][n - j - 1] == 1) {
                    down[n - i - 1][n - j - 1] = i == 0 ? 1 : down[n - i][n - j - 1] + 1;
                    right[n - i - 1][n - j - 1] = j == 0 ? 1 : right[n - i - 1][n - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(up[i][j], Math.min(down[i][j], Math.min(left[i][j], right[i][j]))));
            }
        }
        return ans;
    }
}
