package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 */

public class All_Paths_From_Source_to_Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] neighbours) {
        int n = neighbours.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int neighbour : neighbours[i]) {
                graph[i][neighbour] = 1;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<Integer> curPath = new ArrayList<>();
        curPath.add(0);
        dfs(graph, n, 0, visited, ans, curPath);
        return ans;
    }

    private void dfs(int[][] graph, int n, int index, boolean[] visited, List<List<Integer>> ans, List<Integer> curPath) {
        if (index == n - 1) {
            List<Integer> temp = new ArrayList<>(curPath);
            ans.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (graph[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                curPath.add(i);
                dfs(graph, n, i, visited, ans, curPath);
                curPath.remove(curPath.size() - 1);
                visited[i] = false;
            }
        }
    }


    // 二刷
    public List<List<Integer>> allPathsSourceTarget_2(int[][] graph) {
        int n = graph.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int neighbour : graph[i]) {
                g[i][neighbour] = 1;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<Integer> curPath = new ArrayList<>();
        curPath.add(0);
        dfsTraversal(g, n, 0, visited, ans, curPath);
        return ans;
    }

    public void dfsTraversal(int[][] g, int n, int index, boolean[] visited, List<List<Integer>> ans, List<Integer> curPath) {
        if (index == n - 1) {
            List<Integer> temp = new ArrayList<>(curPath);
            ans.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (g[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                curPath.add(i);
                dfsTraversal(g, n, i, visited, ans, curPath);
                curPath.remove(curPath.size() - 1);
                visited[i] = false;
            }
        }
    }
}
