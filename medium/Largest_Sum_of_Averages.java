package medium;

/**
 * 813. Largest Sum of Averages
 */

public class Largest_Sum_of_Averages {
    // https://leetcode.cn/problems/largest-sum-of-averages/solution/dong-tai-gui-hua-xiang-jie-by-wang-nmana-v1vk/
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        double[] sum = new double[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double[][] dp = new double[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            dp[i][1] = sum[i] / i;
            for (int j = 2; j <= Math.min(k, i); j++) {
                for (int m = 1; m < i; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[m][j - 1] + (sum[i] - sum[m]) / (i - m));
                }
            }
        }
        return dp[len][k];
    }
}
