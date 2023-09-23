package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 */

public class Combinations {

    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        List<List<Integer>> lists = combine(n, k);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(ans, list, n, k, 1);
        return ans;
    }

    public static void generate(List<List<Integer>> ans, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            generate(ans, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }


    // 二刷
    public List<List<Integer>> combine_2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        reverse(res, new ArrayList<>(k), n, k, 1);
        return res;
    }

    private void reverse(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            reverse(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
