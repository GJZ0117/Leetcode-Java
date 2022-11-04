package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 231. Power of Two
 */

public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }
        int pre = 1;
        int cur;
        for (int i = 1; i <= 31; i++) {
            cur = pre * 2;
            if (cur == n) {
                return true;
            } else if (cur > n) {
                return false;
            }
            pre = cur;
        }
        return false;
    }
}
