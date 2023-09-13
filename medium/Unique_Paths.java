package medium;

/**
 * 62. Unique Paths
 */

public class Unique_Paths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(23, 12));
        System.out.println(betterSolution(23, 12));
    }

    //动态规划
    public static int betterSolution(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //该方法结果正确但超时
    public static int uniquePaths(int m, int n) {
        int[] times = {0};
        generate(m, n, 0, 0, times);
        return times[0];
    }

    public static void generate(int m, int n, int cur_i, int cur_j, int[] times) {
        if (cur_i >= m || cur_j >= n) {
            return;
        }

        if (cur_i == m - 1 && cur_j == n - 1) {
            times[0]++;
            return;
        }

        if (cur_i < m) {
            generate(m, n, cur_i + 1, cur_j, times);
        }
        if (cur_j < n) {
            generate(m, n, cur_i, cur_j + 1, times);
        }
    }


    // 二刷
    public int uniquePaths_2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
