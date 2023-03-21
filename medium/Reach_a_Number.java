package medium;

/**
 * 754. Reach a Number
 */

public class Reach_a_Number {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int res = 0;
        int num = 0;
        while (num < target || (num - target) % 2 != 0) {
            num += (++res);
        }
        return res;
    }
}
