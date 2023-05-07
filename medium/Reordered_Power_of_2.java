package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 869. Reordered Power of 2
 */

public class Reordered_Power_of_2 {
    static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 1; i < (int) 1e9; i *= 2) {
            set.add(i);
        }
    }

    int[] count = new int[10];
    int m = 0;

    public boolean reorderedPowerOf2(int n) {
        while (n != 0) {
            count[n % 10]++;
            n /= 10;
            m++;
        }
        return dfs(0, 0);
    }

    private boolean dfs(int n, int cur) {
        if (n == m) {
            return set.contains(cur);
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] != 0) {
                count[i]--;
                if ((i != 0 || cur != 0) && dfs(n + 1, cur * 10 + i)) {
                    return true;
                }
                count[i]++;
            }
        }
        return false;
    }
}
