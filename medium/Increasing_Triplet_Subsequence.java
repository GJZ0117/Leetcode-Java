package medium;

/**
 * 334. Increasing Triplet Subsequence
 */

public class Increasing_Triplet_Subsequence {
    // https://leetcode.cn/problems/increasing-triplet-subsequence/solution/c-xian-xing-shi-jian-fu-za-du-xiang-xi-jie-xi-da-b/
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


    // 二刷（还不会）
    // 两个变量small、mid保存最小值和中间值
    // 遍历数组每个数，若小于等于small则替换small；若小于等于mid则替换mid；若大于mid则说明找到了长度为3的递增数组
    public boolean increasingTriplet_2(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }
        return false;
    }
}
