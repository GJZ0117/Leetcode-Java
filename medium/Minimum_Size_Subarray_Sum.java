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


    // 二刷（还不会）
    public int minSubArrayLen_2(int target, int[] nums) {
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


    // 三刷
    public int minSubArrayLen_3(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (left < right && sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
