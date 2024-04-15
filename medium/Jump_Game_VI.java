package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1696. Jump Game VI
 */

public class Jump_Game_VI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < n; i++) {
            if (stack.peekFirst() < i - k) {
                stack.pollFirst();
            }
            f[i] = f[stack.peekFirst()] + nums[i];
            while (!stack.isEmpty() && f[i] >= f[stack.peekLast()]) {
                stack.pollLast();
            }
            stack.addLast(i);
        }
        return f[n - 1];
    }
}
