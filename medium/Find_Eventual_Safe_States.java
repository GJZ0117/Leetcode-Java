package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 802. Find Eventual Safe States
 */

public class Find_Eventual_Safe_States {
    public List<Integer> eventualSafeNodes(int[][] neighbours) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[neighbours.length];
        for (int i = 0; i < neighbours.length; i++) {
            if (dfs(neighbours, i, visited)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int[][] neighbours, int index, boolean[] visited) {
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        for (int neighbour : neighbours[index]) {
            if (!dfs(neighbours, neighbour, visited)) {
                return false;
            }
        }
        neighbours[index] = new int[0];
        visited[index] = false;
        return true;
    }
}
