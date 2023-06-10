package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 934. Shortest Bridge
 */

public class Shortest_Bridge {
    public int shortestBridge(int[][] grid) {
        int[][] graph = grid;
        int n = graph.length;
        boolean flag = false;
        Deque<int[]> edges = new ArrayDeque<>();
        for (int i = 0; i < n && !flag; i++) {
            for (int j = 0; j < n && !flag; j++) {
                if (graph[i][j] == 1) {
                    markFirstIsland(graph, n, edges, i, j);
                    flag = true;
                }
            }
        }
        int res = 0;
        while (!edges.isEmpty()) {
            res++;
            int len = edges.size();
            while (len > 0) {
                int[] edge = edges.pollFirst();
                int x = edge[0];
                int y = edge[1];
                if (isLegal(x - 1, y, n) && graph[x - 1][y] == 0) {
                    edges.add(new int[]{x - 1, y});
                    graph[x - 1][y] = 2;
                } else if (isLegal(x - 1, y, n) && graph[x - 1][y] == 1) {
                    return res;
                }
                if (isLegal(x + 1, y, n) && graph[x + 1][y] == 0) {
                    edges.add(new int[]{x + 1, y});
                    graph[x + 1][y] = 2;
                } else if (isLegal(x + 1, y, n) && graph[x + 1][y] == 1) {
                    return res;
                }
                if (isLegal(x, y - 1, n) && graph[x][y - 1] == 0) {
                    edges.add(new int[]{x, y - 1});
                    graph[x][y - 1] = 2;
                } else if (isLegal(x, y - 1, n) && graph[x][y - 1] == 1) {
                    return res;
                }
                if (isLegal(x, y + 1, n) && graph[x][y + 1] == 0) {
                    edges.add(new int[]{x, y + 1});
                    graph[x][y + 1] = 2;
                } else if (isLegal(x, y + 1, n) && graph[x][y + 1] == 1) {
                    return res;
                }
                len--;
            }
        }
        return res;
    }

    private void markFirstIsland(int[][] graph, int n, Deque<int[]> edges, int x, int y) {
        if (!isLegal(x, y, n) || graph[x][y] == 2) {
            return;
        }
        if (graph[x][y] == 0) {
            graph[x][y] = 2;
            edges.add(new int[]{x, y});
            return;
        }
        graph[x][y] = 2;
        markFirstIsland(graph, n, edges, x - 1, y);
        markFirstIsland(graph, n, edges, x + 1, y);
        markFirstIsland(graph, n, edges, x, y - 1);
        markFirstIsland(graph, n, edges, x, y + 1);
    }

    private boolean isLegal(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
