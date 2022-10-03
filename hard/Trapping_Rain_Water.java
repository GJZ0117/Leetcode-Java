package hard;

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

}
