package medium;

/**
 * 1094. Car Pooling
 */

public class Car_Pooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1] ;
            int j = trip[2] - 1;
            nums[i] += val;
            if (j + 1 < nums.length) {
                nums[j + 1] -= val;
            }
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
