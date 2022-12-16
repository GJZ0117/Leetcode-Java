package medium;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 */

public class Partition_Equal_Subset_Sum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 10, 6};
        System.out.println(canPartition(nums));
    }

    //https://leetcode.cn/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                // if current num equals to j, dp[i][j] = true
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                // does not store nums[i] : if the subset [0, i-1] contains some numbers whose sum is j, dp[i][j] = true
                // store nums[i] : if the subset [0, i-1] contains some numbers whose sum is j-num[i], dp[i][j] = true
                // otherwise dp[i][j] = false
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void print(boolean[][] dp) {
        for (boolean[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //Time Limit Exceeded
    public boolean _canPartition(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return dfs(nums, 0, total, 0);
    }

    public boolean dfs(int[] nums, int index, int total, int half) {
        if (half == total - half) {
            return true;
        } else if (half > total - half) {
            return false;
        }
        for (int i = index; i < nums.length - 1; i++) {
            if (dfs(nums, i + 1, total, half + nums[i])) {
                return true;
            }
        }
        return false;
    }
}
