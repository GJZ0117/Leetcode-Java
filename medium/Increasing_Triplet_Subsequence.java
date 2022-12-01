package medium;

/**
 * 334. Increasing Triplet Subsequence
 */

public class Increasing_Triplet_Subsequence {
    //https://leetcode.cn/problems/increasing-triplet-subsequence/solution/c-xian-xing-shi-jian-fu-za-du-xiang-xi-jie-xi-da-b/
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= middle) {
                middle = num;
            } else if (num > middle) {
                return true;
            }
        }
        return false;
    }
}
