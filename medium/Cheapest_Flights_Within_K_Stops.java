package medium;

import java.util.Arrays;

/**
 * 787. Cheapest Flights Within K Stops
 */

public class Cheapest_Flights_Within_K_Stops {


    public static void main(String[] args) {
        int n = 3;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 0;
        System.out.println(_findCheapestPrice(n, flights, src, dst, k));
    }


    // https://leetcode.cn/problems/cheapest-flights-within-k-stops/solution/tong-ge-lai-shua-ti-la-yi-ti-si-jie-bfs-deqpt/
    int INF = 1000000;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[dst][0] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                dp[flight[0]][i] = Math.min(dp[flight[0]][i], dp[flight[1]][i - 1] + flight[2]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp[src].length; i++) {
            ans = Math.min(dp[src][i], ans);
        }
        return ans == INF ? -1 : ans;
    }


    // time limit exceeded
    static int minCost = Integer.MAX_VALUE;

    public static int _findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for (int[] arr : graph) {
            Arrays.fill(arr, -1);
        }
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        int[] visited = new int[graph[0].length];
        _dfs(graph, src, dst, k + 1, 0, visited);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public static void _dfs(int[][] graph, int src, int dst, int k, int cost, int[] visited) {
        if (k < 0 || (k == 0 && src != dst) || cost >= minCost) {
            return;
        }
        if (src == dst) {
            minCost = Math.min(minCost, cost);
            return;
        }
        for (int i = 0; i < graph[0].length; i++) {
            if (graph[src][i] != -1 && visited[i] == 0) {
                visited[i] = 1;
                _dfs(graph, i, dst, k - 1, cost + graph[src][i], visited);
                visited[i] = 0;
            }
        }
    }
}
