package medium;

/**
 * 238. Product of Array Except Self
 */

public class Product_of_Array_Except_Self {
    /**
     * numbers: 2       3       4       5
     * left:    1       2       2*3     2*3*4
     * right:   3*4*5   4*5     5       1
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}
