package medium;

/**
 * 304. Range Sum Query 2D - Immutable
 */

public class NumMatrix {

    int m;
    int n;
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return dp[row2][col2];
        } else if (row1 == 0) {
            return dp[row2][col2] - dp[row2][col1 - 1];
        } else if (col1 == 0) {
            return dp[row2][col2] - dp[row1 - 1][col2];
        } else {
            return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
        }
    }
}


class NumMatrix_2 {

    int m;
    int n;
    int[][] matrix;
    int[][] sumMatrix;

    public NumMatrix_2(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        sumMatrix = new int[m][n];
        sumMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            sumMatrix[0][j] = sumMatrix[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumMatrix[i][j] = matrix[i][j] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = sumMatrix[row2][col2];
        if (row1 - 1 >= 0) {
            res -= sumMatrix[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            res -= sumMatrix[row2][col1 - 1];
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            res += sumMatrix[row1 - 1][col1 - 1];
        }
        return res;
    }
}