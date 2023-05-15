package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 886. Possible Bipartition
 */

public class Possible_Bipartition {
    // https://leetcode.cn/problems/possible-bipartition/solution/886-ke-neng-de-er-fen-fa-er-fen-tu-pan-d-r6s8/
    boolean res = true;
    boolean[] color;
    boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
        return res;
    }

    private void dfs(List<Integer>[] graph, int v) {
        if (!res) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            } else {
                if (color[w] == color[v]) {
                    res = false;
                    return;
                }
            }
        }
    }
}
