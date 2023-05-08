package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. Length of Longest Fibonacci Subsequence
 */

public class Length_of_Longest_Fibonacci_Subsequence {
    // https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/solution/pythonjavatypescriptgo-by-himymben-7ci1/
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j], 2);
                int next = arr[i] + arr[j];
                if (map.containsKey(next)) {
                    int idx = map.get(next);
                    dp[j][idx] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[j][idx]);
                }
            }
        }
        return ans;
    }
}
