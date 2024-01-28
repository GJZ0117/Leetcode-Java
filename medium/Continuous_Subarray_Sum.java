package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. Continuous Subarray Sum
 */

public class Continuous_Subarray_Sum {
    // https://leetcode.cn/problems/continuous-subarray-sum/solutions/808246/gong-shui-san-xie-tuo-zhan-wei-qiu-fang-1juse/
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        // 下一个循环开始时候要保证sum[0]=0，才能子数组开始位置为nums[0]的和
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        // 要保证子数组长度大于等于2，sum区间长度也要大于等于2
        for (int i = 2; i < nums.length + 1; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }
}
