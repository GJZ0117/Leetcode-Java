package easy;

/**
 * 674. Longest Continuous Increasing Subsequence
 */

public class Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        int pre = nums[0];
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                pre = nums[i];
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                pre = nums[i];
                curLen = 1;
            }
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
