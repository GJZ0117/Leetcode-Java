package medium;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 */

public class Minimum_Moves_to_Equal_Array_Elements_II {
    // https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solution/by-fuxuemingzhu-13z3/
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        int steps = 0;
        for (int num : nums) {
            steps += Math.abs(num - target);
        }
        return steps;
    }
}
