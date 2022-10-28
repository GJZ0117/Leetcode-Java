package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
