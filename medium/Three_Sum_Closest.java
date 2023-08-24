package medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 */

public class Three_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int cloest = Integer.MAX_VALUE;
        int curSum;
        int curDiff;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                curSum = nums[i] + nums[j] + nums[k];
                curDiff = Math.abs(curSum - target);
                if (curDiff == 0) {
                    return target;
                } else if (curDiff < diff) {
                    cloest = curSum;
                    diff = curDiff;
                }

                if (curSum > target) {
                    k--;
                } else if (curSum < target) {
                    j++;
                }
            }
        }

        return cloest;
    }


    // 二刷
    public int threeSumClosest_2(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int minDiffSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < minDiff) {
                    minDiffSum = sum;
                }
                minDiff = Math.min(minDiff, Math.abs(sum - target));
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return minDiffSum;
    }

}
