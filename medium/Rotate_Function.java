package medium;

/**
 * 396. Rotate Function
 */

public class Rotate_Function {
    //https://leetcode.cn/problems/rotate-function/solution/pythonjavajavascriptgo-by-himymben-anmd/
    // F(k+1) = F(k) + Σ(i:0->n-1)nums[i] - n * nums[-k]
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
            numsSum += nums[i];
        }
        int ans = f;
        for (int i = nums.length-1; i > 0; i--) {
            f = f + numsSum - nums.length * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
