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
}
