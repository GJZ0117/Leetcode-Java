package medium;

/**
 * 209. Minimum Size Subarray Sum
 */

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int minSize = Integer.MAX_VALUE;
        while (right < nums.length) {
            curSum += nums[right];
            while (curSum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
