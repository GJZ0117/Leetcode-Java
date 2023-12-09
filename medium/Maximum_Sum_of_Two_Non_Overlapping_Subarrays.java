package medium;

/**
 * 1031. Maximum Sum of Two Non-Overlapping Subarrays
 */

public class Maximum_Sum_of_Two_Non_Overlapping_Subarrays {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return Math.max(fun(prefix, firstLen, secondLen), fun(prefix, secondLen, firstLen));
    }

    private int fun(int[] prefix, int firstLen, int secondLen) {
        int maxSumA = 0;
        int res = 0;
        for (int i = firstLen + secondLen; i < prefix.length; i++) {
            maxSumA = Math.max(maxSumA, prefix[i - secondLen] - prefix[i - secondLen - firstLen]);
            res = Math.max(res, maxSumA + prefix[i] - prefix[i - secondLen]);
        }
        return res;
    }
}
