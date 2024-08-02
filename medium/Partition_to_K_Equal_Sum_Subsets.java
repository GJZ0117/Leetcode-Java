package medium;

import java.util.Arrays;

/**
 * 698. Partition to K Equal Sum Subsets
 */

public class Partition_to_K_Equal_Sum_Subsets {
    // https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/zhua-wa-mou-si-by-muse-77-hytu/
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0 || nums[nums.length - 1] > sum / k) {
            return false;
        }
        return dfs(nums, nums.length - 1, sum / k, 0, k, flag);
    }

    public boolean dfs(int[] nums, int start, int target, int current, int k, boolean[] flag) {
        if (k == 1) {
            return true;
        }
        if (current == target) {
            return dfs(nums, nums.length - 1, target, 0, k - 1, flag);
        }
        for (int i = start; i >= 0; i--) {
            if (flag[i] || current + nums[i] > target) {
                continue;
            }
            flag[i] = true;
            if (dfs(nums, i - 1, target, current + nums[i], k, flag)) {
                return true;
            }
            flag[i] = false;
            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            }
        }
        return false;
    }


    // 二刷
    public boolean canPartitionKSubsets_2(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        int sum = Arrays.stream(nums).sum();
        if (nums[nums.length - 1] > sum / k || sum % k != 0) {
            return false;
        }
        return traversal(nums, nums.length - 1, sum / k, 0, k, visited);
    }

    public boolean traversal(int[] nums, int end, int target, int current, int step, boolean[] visited) {
        if (step == 1) {
            return true;
        }
        if (current == target) {
            return traversal(nums, nums.length - 1, target, 0, step - 1, visited);
        }
        for (int i = end; i >= 0; i--) {
            if (visited[i] || current + nums[i] > target) {
                continue;
            }
            visited[i] = true;
            if (traversal(nums, i - 1, target, current + nums[i], step, visited)) {
                return true;
            }
            visited[i] = false;
            while (i > 0 && nums[i - 1] == nums[i]) {
                i--;
            }
        }
        return false;
    }
}
