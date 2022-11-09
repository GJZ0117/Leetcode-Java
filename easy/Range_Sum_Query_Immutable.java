package easy;

/**
 * 303. Range Sum Query - Immutable
 */

public class Range_Sum_Query_Immutable {
    int[] nums;

    public Range_Sum_Query_Immutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += this.nums[i];
        }
        return ans;
    }
}
