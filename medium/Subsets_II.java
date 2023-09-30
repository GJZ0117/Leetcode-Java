package medium;

import java.util.*;

/**
 * 90. Subsets II
 */

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(ans, list, nums, 0);
        return ans;
    }

    public void generate(List<List<Integer>> ans, List<Integer> list, int[] nums, int start) {
        List<Integer> temp = new ArrayList<>(list);
        ans.add(temp);
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            generate(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }


    // 二刷
    public List<List<Integer>> subsetsWithDup_2(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        recurse(nums, 0, set, new ArrayList<>());
        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;
    }

    private void recurse(int[] num, int index, Set<List<Integer>> set, List<Integer> list) {
        set.add(new ArrayList<>(list));
        for (int i = index; i < num.length; i++) {
            list.add(num[i]);
            recurse(num, i + 1, set, list);
            list.remove(list.size() - 1);
        }
    }
}
