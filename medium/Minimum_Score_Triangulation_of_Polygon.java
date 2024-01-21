package medium;

import java.util.Arrays;

/**
 * 1039. Minimum Score Triangulation of Polygon
 */

public class Minimum_Score_Triangulation_of_Polygon {
    // https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/solutions/2203005/shi-pin-jiao-ni-yi-bu-bu-si-kao-dong-tai-aty6/
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1); // -1表示没访问过
        }
        return dfs(memo, values, 0, n - 1);
    }

    private int dfs(int[][] memo, int[] values, int i, int j) {
        if (i + 1 == j) { // 只有两个点无法构成三角形
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(memo, values, i, k) + dfs(memo, values, k, j) + values[i] * values[j] * values[k]);
        }
        memo[i][j] = res;
        return res;
    }
}
