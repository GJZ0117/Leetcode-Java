package medium;

import java.util.Arrays;

/**
 * 945. Minimum Increment to Make Array Unique
 */

public class Minimum_Increment_to_Make_Array_Unique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                result += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }
}
