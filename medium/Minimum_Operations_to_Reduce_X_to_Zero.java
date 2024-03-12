package medium;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 */

public class Minimum_Operations_to_Reduce_X_to_Zero {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int ans = -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < nums.length) {
            window += nums[right];
            while (window > target) {
                window -= nums[left++];
            }
            if (window == target) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }

        return ans == -1 ? -1 : nums.length - ans;
    }
}
