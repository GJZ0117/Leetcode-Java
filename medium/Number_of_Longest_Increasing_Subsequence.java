package medium;

import java.util.Arrays;

/**
 * 673. Number of Longest Increasing Subsequence
 */

public class Number_of_Longest_Increasing_Subsequence {
    // https://leetcode.cn/problems/number-of-longest-increasing-subsequence/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dp673-9txt/
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
                maxCount = Math.max(maxCount, dp[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxCount) {
                res += count[i];
            }
        }
        return res;
    }
}
