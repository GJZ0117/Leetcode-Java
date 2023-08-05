package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1015. Smallest Integer Divisible by K
 */

public class Smallest_Integer_Divisible_by_K {
    public int smallestRepunitDivByK(int k) {
        int resid = 1 % k;
        int len = 1;
        Set<Integer> set = new HashSet<>();
        set.add(resid);
        while (resid != 0) {
            resid = (resid * 10 + 1) % k;
            len++;
            if (set.contains(resid)) {
                return -1;
            }
            set.add(resid);
        }
        return len;
    }
}
