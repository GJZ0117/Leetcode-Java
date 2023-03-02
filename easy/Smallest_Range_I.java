package easy;

/**
 * 908. Smallest Range I
 */

public class Smallest_Range_I {
    public int smallestRangeI(int[] nums, int k) {
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        if (maxNum - minNum <= 2 * k) {
            return 0;
        } else {
            return maxNum - minNum - 2 * k;
        }
    }
}
