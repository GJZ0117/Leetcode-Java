package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 869. Reordered Power of 2
 */

public class Reordered_Power_of_2 {
    static Set<int[]> set = new HashSet<>();

    static {
        for (int i = 1; i < (int) 1e9; i *= 2) {
            set.add(count(i));
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] cnt = count(n);
        for (int[] arr : set) {
            if (Arrays.equals(cnt, arr)) {
                return true;
            }
        }
        return false;
    }

    public static int[] count(int num) {
        int[] cnt = new int[10];
        while (num != 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        return cnt;
    }
}
