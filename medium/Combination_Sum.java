package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 */

public class Combination_Sum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinate(candidates, target, list, 0, 0, ans);
        return ans;
    }

    public static void combinate(int[] candidates, int target, List<Integer> list, int curSum, int curIndex, List<List<Integer>> ans) {
        if (curSum > target) { // curSum大于target，回溯
            return;
        } else if (curSum == target) { // curSum等于target，添加到ans中
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(list);
            ans.add(tempList);
            return;
        } else { // curSum小于target，采用回溯法递归遍历
            for (int i = curIndex; i < candidates.length; i++) {
                curSum = curSum + candidates[i];
                list.add(candidates[i]);
                curIndex = i;
                combinate(candidates, target, list, curSum, curIndex, ans);
                curSum = curSum - candidates[i];
                list.remove(list.size() - 1);
            }
        }
    }


    // 二刷
    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index, int curSum) {
        if (curSum > target) {
            return;
        } else if (curSum == target) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
        } else {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(candidates, target, res, list, i, curSum + candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }


    // 三刷
    public List<List<Integer>> combinationSum_3(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(candidates, 0, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void traversal(int[] candidates, int index, int target, int curSum, List<List<Integer>> ans, List<Integer> list) {
        if (curSum > target) {
            return;
        } else if (curSum == target) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                traversal(candidates, i, target, curSum + candidates[i], ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
