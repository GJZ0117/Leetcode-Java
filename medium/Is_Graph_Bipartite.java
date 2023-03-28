package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 785. Is Graph Bipartite?
 */

public class Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visit = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (visit[i] != 0) {
                continue;
            }
            queue.offer(i);
            visit[i] = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int neighbour : graph[v]) {
                    if (visit[neighbour] == visit[v]) {
                        return false;
                    }
                    if (visit[neighbour] == 0) {
                        visit[neighbour] = -visit[v];
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return true;
    }
}
