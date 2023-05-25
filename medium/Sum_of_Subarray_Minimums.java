package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 907. Sum of Subarray Minimums
 */

public class Sum_of_Subarray_Minimums {
    // https://leetcode.cn/problems/sum-of-subarray-minimums/solution/by-ac_oier-w2ya/
    int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                right[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                left[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            int a = i - left[i];
            int b = right[i] - i;
            ans += a * 1L * b % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        return ans;
    }
}
