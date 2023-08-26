package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 */

public class Four_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) { //leap the same numbers which i points
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) { // leap the same numbers which j points
                    continue;
                }

                //use two pointers m and n to traverse the remaining numbers (from j+1 to the end)
                int m = j + 1;
                int n = nums.length - 1;

                while (m < n) {

                    long curSum = (long) nums[i] + (long) nums[j] + (long) nums[m] + (long) nums[n];
                    // check if the summary of four nums is larger than the max integer or smaller than the min integer
                    if (curSum > Integer.MAX_VALUE) {
                        do {
                            n--;
                        } while (m < n && nums[n] == nums[n + 1]);
                        continue;
                    } else if (curSum < Integer.MIN_VALUE) {
                        do {
                            m++;
                        } while (m < n && nums[m] == nums[m - 1]);
                        continue;
                    }

                    //if the summary equals to the target, add them to the list
                    if ((int) curSum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        ans.add(list);
                        do { // leap the same numbers which m points
                            m++;
                        } while (m < n && nums[m] == nums[m - 1]);
                        do { // leap the same numbers which n points
                            n--;
                        } while (m < n && nums[n] == nums[n + 1]);
                    } else if ((int) curSum > target) {
                        do {
                            n--;
                        } while (m < n && nums[n] == nums[n + 1]);
                    } else {
                        do {
                            m++;
                        } while (m < n && nums[m] == nums[m - 1]);
                    }
                }

            }
        }
        return ans;
    }


    // 二刷
    public List<List<Integer>> fourSum_2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];

                    if (sum > Integer.MAX_VALUE) {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                        continue;
                    } else if (sum < Integer.MIN_VALUE) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        continue;
                    }

                    if ((int) sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if ((int) sum > target) {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return res;
    }

}
