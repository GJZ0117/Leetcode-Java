package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 */

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new ArrayList<>();
        lists = permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(ans, nums, 0, nums.length - 1);
        return ans;
    }

    public static void generate(List<List<Integer>> ans, int[] nums, int start, int end) {
        if (start == end) {
            List tempList = new ArrayList();
            for (int i : nums) {
                tempList.add(i);
            }
            ans.add(tempList);
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, i, start);
                generate(ans, nums, start + 1, end);
                swap(nums, i, start);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 二刷
    public List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            res.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                change(nums, index, i);
                dfs(nums, res, index + 1);
                change(nums, index, i);
            }
        }
    }

    private void change(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 三刷
    public List<List<Integer>> permute_3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        traversal(nums, 0, ans);
        return ans;
    }

    public void traversal(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ans.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                swapArr(nums, index, i);
                traversal(nums, index + 1, ans);
                swapArr(nums, index, i);
            }
        }
    }

    public void swapArr(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
