package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 313. Super Ugly Number
 */

public class Super_Ugly_Number {

    public static void main(String[] args) {
        int n = 5911;
        int[] primes = {2, 3, 5, 7};
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


    // 二刷
    public int nthSuperUglyNumber_2(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int num = 1;
        queue.add(1);
        set.add(1);
        while (n > 0) {
            num = queue.poll();
            for (int prime : primes) {
                if (prime <= Integer.MAX_VALUE / num && !set.contains(prime * num)) {
                    queue.add(prime * num);
                    set.add(prime * num);
                }
                if (num % prime == 0) {
                    break;
                }
            }
            n--;
        }
        return num;
    }
}
