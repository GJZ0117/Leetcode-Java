package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 */

public class Combination_Sum_II {

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int endIndex = candidates.length - 1;
        while (endIndex >= 0 && candidates[endIndex] > target) {
            endIndex--;
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, list, candidates, 0, target, endIndex);
        return ans;

    }

    public static void generate(List<List<Integer>> ans, List<Integer> list, int[] candidates, int start, int remain, int endIndex) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= endIndex; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) { //skip duplicates
                    continue;
                }
                list.add(candidates[i]);
                generate(ans, list, candidates, i + 1, remain - candidates[i], endIndex);
                list.remove(list.size() - 1);
            }
        }
    }
}
