package medium;

/**
 * 152. Maximum Product Subarray
 */

public class Maximum_Product_Subarray {

    public int betterSolution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(nums[i], Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(nums[i], Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            ans = Math.max(ans, maxDP[i]);
        }
        return ans;
    }

    // Time Limit Exceeded
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i][i] > ans) {
                ans = dp[i][i];
            }
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] * nums[j];
                if (dp[i][j] > ans) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }


    // 二刷（还不会）
    public int maxProduct_2(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
