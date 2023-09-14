package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5
 */

public class Binary_Prefix_Divisible_By_5 {
    // (a * b + c) % d = ((a % d) * (b % d) + c % d) % d
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int num = 0;
        for (int n : nums) {
            num = ((num << 1) + n) % 5;
            list.add(num == 0);
        }
        return list;
    }
}
