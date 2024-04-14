package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1425. Constrained Subsequence Sum
 */

public class Constrained_Subsequence_Sum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);

        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && i - stack.peekFirst() > k) {
                stack.pollFirst();
            }
            dp[i] = Math.max(dp[stack.peekFirst()], 0) + nums[i];
            ans = Math.max(ans, dp[i]);
            while (!stack.isEmpty() && dp[i] >= dp[stack.peekLast()]) {
                stack.pollLast();
            }
            stack.addLast(i);
        }
        return ans;
    }
}
