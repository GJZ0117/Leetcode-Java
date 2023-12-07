package medium;

import java.util.Arrays;

/**
 * 204. Count Primes
 */

public class Count_Primes {
    // https://leetcode.cn/problems/count-primes/solutions/507445/kuai-lai-miao-dong-shai-zhi-shu-by-sweetiee/
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        for (int i = 2; i * i < n; i++) {
            if (flag[i]) {
                for (int j = i * i; j < n; j+=i) {
                    flag[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                count++;
            }
        }
        return count;
    }
}
