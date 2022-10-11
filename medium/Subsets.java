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
}
