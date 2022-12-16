package medium;

/**
 * 413. Arithmetic Slices
 */

public class Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int ans = 0;
        int preDiff = nums[0] - nums[1];
        int curDiff = 0;
        int times = 1;

        for (int i = 1; i < nums.length - 1; i++) {
            curDiff = nums[i] - nums[i + 1];
            if (preDiff == curDiff) {
                times++;
            } else {
                preDiff = curDiff;
                if (times >= 2) {
                    times -= 1;
                    while (times > 0) {
                        ans += times;
                        times--;
                    }
                }
                times = 1;
            }
        }

        if (times >= 2) {
            times -= 1;
            while (times > 0) {
                ans += times;
                times--;
            }
        }

        return ans;
    }
}
