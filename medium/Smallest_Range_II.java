package medium;

import java.util.Arrays;

/**
 * 910. Smallest Range II
 */

public class Smallest_Range_II {
    /**
     * 首先对数组排序，排序后的数组中，一定有一个位置 i，i 本身及左测全部加 K,i 右侧全部减 K
     * 即A[0]..A[i]全部加上K，A[i+1]..A[n-1]全部减去 K
     * 此时整个数组的最大值是 A[n-1]-K 或 A[i]+K，最小值是 A[0]+K 或 A[i+1]-K
     * 有了这个前提后，就可以线性扫描 i从0到 n-2(i 等于 n-1相当于全部加 K，也就是原始的最大值-最小值)，求出最小的可能值
     */
    public int smallestRangeII(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int high = Math.max(nums[n - 1] - k, a + k);
            int low = Math.min(nums[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}
