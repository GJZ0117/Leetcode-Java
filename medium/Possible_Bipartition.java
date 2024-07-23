package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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


    // 二刷
    public boolean possibleBipartition_2(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] dis : dislikes) {
            g[dis[0]].add(dis[1]);
            g[dis[1]].add(dis[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                Deque<Integer> queue = new ArrayDeque<>();
                queue.addLast(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int cur = queue.removeFirst();
                    for (int neighbour : g[cur]) {
                        if (color[neighbour] > 0 && color[neighbour] == color[cur]) {
                            return false;
                        }
                        if (color[neighbour] == 0) {
                            // 0表示未分组，1表示分组1，2表示分组2 在进行使用时，采用异或， 3（11）异或1（01）得到2（10），3（11）异或2（10）得到1（01）
                            color[neighbour] = 3 ^ color[cur];
                            queue.addLast(neighbour);
                        }
                    }
                }
            }
        }
        return true;
    }
}
