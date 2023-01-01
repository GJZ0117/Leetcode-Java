package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132 Pattern
 */

public class OneThreeTwo_Pattern {
    // https://leetcode.cn/problems/132-pattern/solution/xiang-xin-ke-xue-xi-lie-xiang-jie-wei-he-95gt/
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                k = Math.max(k, deque.pollLast());
            }
            deque.addLast(nums[i]);
        }
        return false;
    }
}
