package easy;

import java.util.Arrays;

/**
 * 561. Array Partition
 */

public class Array_Partition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
