package medium;

import java.util.*;

/**
 * 47. Permutations II
 */

public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length == 0) {
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
        for (int i=index; i<nums.length; i++) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                generate(ans, nums, index+1);
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
