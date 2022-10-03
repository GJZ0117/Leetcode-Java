package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 */

public class Combination_Sum {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists){
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
        if (curSum > target) { //curSum大于target，回溯
            return;
        } else if (curSum == target) { //curSum等于target，添加到ans中
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(list);
            ans.add(tempList);
            return;
        } else { //curSum小于target，采用回溯法递归遍历
            for (int i = curIndex; i < candidates.length; i++) {
                curSum = curSum + candidates[i];
                list.add(candidates[i]);
                curIndex = i;
                combinate(candidates, target, list, curSum, curIndex, ans);
                curSum = curSum - candidates[i];
                list.remove(list.size()-1);
            }
        }
    }
}
