package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 851. Loud and Rich
 */

public class Loud_and_Rich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] graph = new int[n][n];
        int[] in = new int[n];

        for (int[] rich : richer) {
            graph[rich[0]][rich[1]] = 1;
            in[rich[1]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    if (quiet[ans[cur]] < quiet[ans[i]]) {
                        ans[i] = ans[cur];
                    }
                    if (--in[i] == 0) {
                        deque.addLast(i);
                    }
                }
            }
        }
        return ans;
    }
}
