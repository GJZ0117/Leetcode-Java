package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Non-decreasing Subsequences
 */

public class Non_decreasing_Subsequences {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 3};
        List<List<Integer>> ans = findSubsequences(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                if (list.size() >= 2) {
                    List<Integer> temp = new ArrayList<>(list);
                    ans.add(temp);
                }
                dfs(nums, ans, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
