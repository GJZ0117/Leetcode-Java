package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 962. Maximum Width Ramp
 */

public class Maximum_Width_Ramp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peekLast()] > nums[i]) {
                stack.add(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                int pos = stack.pollLast();
                maxWidth = Math.max(maxWidth, i - pos);
            }
        }
        return maxWidth;
    }
}