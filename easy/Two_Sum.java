package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.Two Sum
 */
public class Two_Sum {
    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;
//        int[] ans = twoSum(nums, target);
//        System.out.println(Arrays.toString(ans));

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));

//        int[] nums = {3, 3};
//        int target = 6;
//        int[] ans = twoSum(nums, target);
//        System.out.println(Arrays.toString(ans));
    }

    // O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int i, j;
        boolean flag = false;
        for (i = 0; i < nums.length && !flag; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }


    // O(n)
    public static int[] twoSumBetterSolution(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    // 二刷
    public int[] twoSum_2(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
