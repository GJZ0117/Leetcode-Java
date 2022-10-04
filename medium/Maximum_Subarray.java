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
        int maxSum = -1000;
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

}
