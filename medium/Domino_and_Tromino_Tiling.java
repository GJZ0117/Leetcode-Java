package medium;

/**
 * 790. Domino and Tromino Tiling
 */

public class Domino_and_Tromino_Tiling {
    private long MOD = (long) 1e9 + 7;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % MOD;
        }
        return (int) dp[n];
    }
}
