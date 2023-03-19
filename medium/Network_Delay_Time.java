package medium;

import java.util.Arrays;

/**
 * 743. Network Delay Time
 */

public class Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int[] arr : times) {
            graph[arr[0] - 1][arr[1] - 1] = arr[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;

        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }

            used[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + graph[x][y]);
            }
        }

        int ans = -1;
        for (int d : dist) {
            ans = Math.max(ans, d);
        }
        return ans == INF ? -1 : ans;
    }
}
