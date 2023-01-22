package medium;

import java.util.*;

/**
 * 532. K-diff Pairs in an Array
 */

public class Kdiff_Pairs_in_an_Array {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int pre1 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == pre1) {
                continue;
            } else {
                pre1 = nums[i];
            }
            int pre2 = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == pre2) {
                    continue;
                } else {
                    pre2 = nums[j];
                }
                int diff = nums[j] - nums[i];
                if (diff == k) {
                    ans++;
                } else if (diff > k) {
                    break;
                }
            }
        }
        return ans;
    }
}
