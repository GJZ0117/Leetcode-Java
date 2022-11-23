package hard;

import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 */

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                ans[left] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}