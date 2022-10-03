package easy;

/**
 * 1480. Running Sum of 1d Array
 */
public class Running_Sum_of_1d_Array {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] + nums[i];
        }
        return ans;
    }
}