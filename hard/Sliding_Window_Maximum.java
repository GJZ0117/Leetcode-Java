package hard;

import java.util.Deque;
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


    // 二刷
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && queue.peekFirst() == nums[i - 1]) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.pollLast();
            }
            queue.addLast(nums[j]);
            if (i >= 0) {
                ans[i] = queue.peekFirst();
            }
        }
        return ans;
    }
}