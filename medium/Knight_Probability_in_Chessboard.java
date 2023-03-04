package medium;

/**
 * 688. Knight Probability in Chessboard
 */

public class Knight_Probability_in_Chessboard {
    //https://leetcode.cn/problems/knight-probability-in-chessboard/solution/tong-ge-lai-shua-ti-la-yi-ti-liang-jie-j-y92k/
    private int[][] DIRS = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return dfs(n, k, row, column, memo);
    }

    public double dfs(int n, int k, int i, int j, double[][][] memo) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }

        double ans = 0;
        for (int[] dir : DIRS) {
            ans += dfs(n, k - 1, i + dir[0], j + dir[1], memo) / 8.0;
        }
        memo[i][j][k] = ans;
        return ans;
    }
}
