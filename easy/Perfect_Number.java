package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 507. Perfect Number
 */

public class Perfect_Number {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
        }
        int sum = 0;
        for (int n : set) {
            sum += n;
            if (sum > num) {
                return false;
            }
        }
        return sum == num;
    }
}
