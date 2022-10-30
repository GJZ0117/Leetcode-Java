package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 */

public class Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int curSum;
        int temp;

        while (true) {
            curSum = 0;
            while (n!=0) {
                temp = n % 10;
                n /= 10;
                curSum += Math.pow(temp, 2);
            }

            if (curSum == 1) {
                return true;
            }

            if (set.contains(curSum)) {
                return false;
            }else {
                set.add(curSum);
            }
            n = curSum;
        }
    }
}
