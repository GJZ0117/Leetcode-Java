package medium;

/**
 * 1004. Max Consecutive Ones III
 */

public class Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }


    // 二刷
    public int longestOnes_2(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int remain = k;
        while (right < nums.length) {
            if (nums[right] == 0) {
                remain--;
            }
            while (remain < 0) {
                if (nums[left] == 0) {
                    remain++;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
