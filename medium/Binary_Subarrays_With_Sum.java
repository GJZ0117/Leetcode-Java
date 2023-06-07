package medium;

/**
 * 930. Binary Subarrays With Sum
 */

public class Binary_Subarrays_With_Sum {
    // https://leetcode.cn/problems/binary-subarrays-with-sum/solution/930-he-xiang-tong-de-er-yuan-zi-shu-zu-h-w5o4/
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int left1 = 0;
        int left2 = 0;
        int right = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (right < nums.length) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ans += left2 - left1;
            right++;
        }
        return ans;
    }
}
