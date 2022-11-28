package medium;

import java.util.Arrays;

/**
 * 313. Super Ugly Number
 */

public class Super_Ugly_Number {

    public static void main(String[] args) {
        int n = 5911;
        int[] primes = {2,3,5,7};
        System.out.println(nthSuperUglyNumber(n, primes));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        int[] bases = new int[primes.length];
        int[] temps = new int[primes.length];
        int minValue;

        for (int i = 0; i < primes.length; i++) {
            bases[i] = 1;
        }

        for (int index = 2; index <= n; index++) {
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                int temp = ans[bases[i]] * primes[i];
                if (temp > 0) {
                    temps[i] = ans[bases[i]] * primes[i];
                    minValue = Math.min(temps[i], minValue);
                }
            }
            for (int i = 0; i < primes.length; i++) {
                if (temps[i] == minValue) {
                    bases[i]++;
                }
            }
            ans[index] = minValue;
        }
        System.out.println(Arrays.toString(ans));
        return ans[n];
    }
}
