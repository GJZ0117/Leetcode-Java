package medium;

import java.util.*;

/**
 * 47. Permutations II
 */

public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        generate(ans, nums, 0);
        return ans;
    }

    public void generate(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                generate(ans, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 二刷(还不会)
    // https://leetcode.cn/problems/permutations-ii/solutions/418230/47-quan-pai-lie-iiche-di-li-jie-pai-lie-zhong-de-q/

    public List<List<Integer>> permuteUnique_2(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used, res, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
