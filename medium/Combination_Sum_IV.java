package medium;

import java.util.Arrays;

/**
 * 377. Combination Sum IV
 */

public class Combination_Sum_IV {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 32;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int n : nums) {
            if (n >= 0 && n <= target) {
                dp[n]++;
            }
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0 && i - nums[j] <= target) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    //Time Limit Exceeded
    public int _combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = {0};
        dfs(nums, 0, target, res);
        return res[0];
    }

    public void dfs(int[] nums, int start, int remain, int[] res) {
        if (remain == 0) {
            res[0]++;
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (remain < nums[i]) {
                break;
            }
            dfs(nums, start, remain - nums[i], res);
        }
    }
}
