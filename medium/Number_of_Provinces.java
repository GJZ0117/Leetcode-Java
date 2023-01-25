package medium;

/**
 * 547. Number of Provinces
 */

public class Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, n, i, visited);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, int n, int index, boolean[] visited) {
        visited[index] = true;
        for (int j = 0; j < n; j++) {
            if (!visited[j] && isConnected[index][j] == 1) {
                dfs(isConnected, n, j, visited);
            }
        }
    }
}
