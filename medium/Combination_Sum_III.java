package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. Combination Sum III
 */

public class Combination_Sum_III {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dfs(ans, list, k, n, 1, 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> list, int k, int n, int start, int curSum) {
        if (list.size() == k && curSum == n) {
            List<Integer> temp = new LinkedList<>(list);
            ans.add(temp);
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (list.size() == k) {
                return;
            }
            list.add(i);
            dfs(ans, list, k, n, i + 1, curSum + i);
            list.remove(list.size() - 1);
        }
    }


    // 二刷
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        fun(res, new ArrayList<>(), k, n, 1, 0);
        return res;
    }

    private void fun(List<List<Integer>> res, List<Integer> list, int k, int n, int start, int sum) {
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            fun(res, list, k, n, i + 1, sum + i);
            list.remove(list.size() - 1);
        }
    }


    // 三刷
    public List<List<Integer>> combinationSum3_3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(k, n, 1, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void traversal(int k, int n, int start, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            traversal(k, n, i + 1, sum + i, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
