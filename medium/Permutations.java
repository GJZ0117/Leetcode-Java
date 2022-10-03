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
}
