package medium;

/**
 * 1027. Longest Arithmetic Subsequence
 */

public class Longest_Arithmetic_Subsequence {
    // https://leetcode.cn/problems/longest-arithmetic-subsequence/solutions/2239444/python3javacgotypescript-yi-ti-yi-jie-do-h9lz/
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < i; k++) {
                int j = nums[i] - nums[k] + 500;
                dp[i][j] = Math.max(dp[i][j], dp[k][j] + 1);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans + 1;
    }
}
