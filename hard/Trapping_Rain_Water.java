package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 */

public class Trapping_Rain_Water {

    /**
     * https://leetcode.com/problems/trapping-rain-water/discuss/17357/Sharing-my-simple-c%2B%2B-code%3A-O(n)-time-O(1)-space
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res = res + (maxLeft - height[left]);
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res = res + (maxRight - height[right]);
                }
                right--;
            }
        }
        return res;
    }


    // 二刷
    // https://leetcode.cn/problems/trapping-rain-water/solutions/185678/trapping-rain-water-by-ikaruga/?show=1
    public int trap_2(int[] height) {
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                int cur = deque.poll();
                if (deque.isEmpty()) {
                    break;
                }
                int left = deque.peek();
                int right = i;
                int h = Math.min(height[right], height[left]) - height[cur];
                ans += (right - left - 1) * h;
            }
            deque.push(i);
        }
        return ans;
    }
}
