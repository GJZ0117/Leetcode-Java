package medium;

/**
 * 740. Delete and Earn
 */

public class Delete_and_Earn {
    // https://leetcode.cn/problems/delete-and-earn/solution/ru-guo-ni-li-jie-liao-da-jia-jie-she-zhe-ti-ni-ken/
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] all = new int[max + 1];
        for (int n : nums) {
            all[n]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i] * i);
        }
        return dp[max];
    }
}
