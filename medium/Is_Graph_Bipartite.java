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


    // 二刷
    public boolean isBipartite_3(int[][] graph) {
        int[] visited = new int[graph.length];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            queue.addLast(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.removeLast();
                for (int neighbour : graph[cur]) {
                    if (visited[neighbour] == visited[cur]) {
                        return false;
                    }
                    if (visited[neighbour] == 0) {
                        visited[neighbour] = -visited[cur];
                        queue.addLast(neighbour);
                    }
                }
            }
        }
        return true;
    }
}
