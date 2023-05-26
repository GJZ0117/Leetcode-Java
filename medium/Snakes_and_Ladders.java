package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 909. Snakes and Ladders
 */

public class Snakes_and_Ladders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] nums = twoForOne(board, n);
        boolean[] visited = new boolean[n * n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        deque.offer(1);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                int cur = deque.poll();
                if (cur == n * n) {
                    return ans;
                }
                if (!visited[cur]) {
                    BFS(deque, cur, nums);
                    visited[cur] = true;
                }
            }
            ans++;
        }
        return -1;
    }

    public int[] twoForOne(int[][] board, int n) {
        int[] nums = new int[n * n + 1];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            int row = n - i;
            if (row % 2 == 1) {
                for (int j = 0; j < n; j++) {
                    nums[++index] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    nums[++index] = board[i][j];
                }
            }
        }
        return nums;
    }

    public void BFS(Deque<Integer> deque, int cur, int[] nums) {
        int N = 6;
        for (int i = 1; i <= N && (cur + i) < nums.length; i++) {
            if (nums[cur + i] == -1) {
                deque.offer(cur + i);
            } else {
                deque.offer(nums[cur + i]);
            }
        }
    }
}
