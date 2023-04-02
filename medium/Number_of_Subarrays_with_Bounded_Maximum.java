package medium;

/**
 * 795. Number of Subarrays with Bounded Maximum
 */

public class Number_of_Subarrays_with_Bounded_Maximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i = 0;
        int j = -1;
        int k = -1;
        int ans = 0;
        while (i < nums.length) {
            if (nums[i] > right) {
                k = i;
            } else {
                if (nums[i] < left) {
                    if (j > k) {
                        ans += j - k;
                    }
                } else {
                    ans += i - k;
                    j = i;
                }
            }
            i++;
        }
        return ans;
    }
}
