package medium;

/**
 * 343. Integer Break
 */

public class Integer_Break {

    public static void main(String[] args) {
        for (int n = 2; n < 20; n++) {
            System.out.println(integerBreak(n) + " " + _integerBreak(n));
        }
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    //Time Limit Exceeded
    public static int _integerBreak(int n) {
        int[] res = {0};
        dfs(n, n, 1, res);
        return res[0];
    }

    public static void dfs(int n, int remain, int tempRes, int[] res) {
        if (remain == 0) {
            res[0] = Math.max(res[0], tempRes);
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = 1; i <= (remain == n ? remain - 1 : remain); i++) {
            dfs(n, remain - i, tempRes * i, res);
        }
    }
}
