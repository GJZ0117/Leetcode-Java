package medium;

/**
 * 926. Flip String to Monotone Increasing
 */

public class Flip_String_to_Monotone_Increasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        if (s.charAt(0) == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
