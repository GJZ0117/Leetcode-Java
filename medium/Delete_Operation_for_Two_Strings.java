package medium;

/**
 * 583. Delete Operation for Two Strings
 */

public class Delete_Operation_for_Two_Strings {
    // https://leetcode.cn/problems/delete-operation-for-two-strings/solution/gong-shui-san-xie-cong-liang-chong-xu-li-wqv7/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
