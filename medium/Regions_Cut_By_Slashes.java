package medium;

/**
 * 959. Regions Cut By Slashes
 */

public class Regions_Cut_By_Slashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] graph = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    graph[i * 3 + 2][j * 3] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3][j * 3 + 2] = 1;
                } else if (grid[i].charAt(j) == ' ') {
                    continue;
                } else {
                    graph[i * 3][j * 3] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, graph.length, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] graph, int n, int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n && graph[i][j] == 0) {
            graph[i][j] = 1;
            dfs(graph, n, i - 1, j);
            dfs(graph, n, i + 1, j);
            dfs(graph, n, i, j - 1);
            dfs(graph, n, i, j + 1);
        }
    }
}
