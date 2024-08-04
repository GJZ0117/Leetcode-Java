package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 */

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(nums, ans, list, 0);
        return ans;
    }

    public static void generate(int[] nums, List<List<Integer>> ans, List<Integer> list, int start) {
        List<Integer> temp = new ArrayList<>(list);
        ans.add(temp);
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            generate(nums, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    // 二刷
    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        recurse(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    private void recurse(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            recurse(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }


    // 三刷
    public List<List<Integer>> subsets_3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }
}
