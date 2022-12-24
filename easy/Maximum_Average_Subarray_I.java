package easy;

/**
 * 643. Maximum Average Subarray I
 */

public class Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int curSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        curSum = maxSum - nums[0];
        for (int i = k; i < nums.length; i++) {
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            curSum -= nums[i - k + 1];
        }
        return (double) maxSum / k;
    }
}
