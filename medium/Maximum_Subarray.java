package medium;

/**
 * 53. Maximum Subarray
 */

public class Maximum_Subarray {

    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = -100000;
        for (int i = 0; i < nums.length; i++) {
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    // 二刷
    public int maxSubArray_2(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        if (maxNum <= 0) {
            return maxNum;
        }
        int curSum = 0;
        int ans = 0;
        for (int num : nums) {
            if (curSum >= 0) {
                curSum += num;
            } else {
                curSum = num;
            }
            ans = Math.max(ans, curSum);
        }
        return ans;
    }
}
