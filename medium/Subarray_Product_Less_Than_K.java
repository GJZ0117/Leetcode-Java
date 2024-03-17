package medium;

/**
 * 713. Subarray Product Less Than K
 */

public class Subarray_Product_Less_Than_K {
    // https://leetcode.cn/problems/subarray-product-less-than-k/solution/jian-dan-yi-dong-xiang-xi-zhu-jie-shuang-jvy3/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int multi = 1;
        int ans = 0;
        while (right < nums.length) {
            multi *= nums[right];
            while (left <= right && multi >= k) {
                multi /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }


    // 二刷
    public int numSubarrayProductLessThanK_2(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int multi = 1;
        int ans = 0;
        while (right < nums.length) {
            multi *= nums[right];
            if (multi < k) {
                ans += right - left + 1;
            } else {
                while (left <= right && multi >= k) {
                    multi /= nums[left++];
                }
                ans += right - left + 1;
            }
            right++;
        }
        return ans;
    }
}
