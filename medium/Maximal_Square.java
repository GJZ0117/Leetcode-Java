package medium;

/**
 * 221. Maximal Square
 */

public class Maximal_Square {

    public int betterSolution(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxEdge = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }
        return maxEdge * maxEdge;
    }

    //Time Limit Exceeded
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int curSquare = 1;
                    int offset = 1;
                    while (offset + i < m && offset + j < n) {
                        boolean flag = checkSquare(matrix, i, j, offset);
                        if (flag) {
                            curSquare = (1 + offset) * (1 + offset);
                            offset++;
                        } else {
                            break;
                        }
                    }
                    maxSquare = Math.max(maxSquare, curSquare);
                }
            }
        }
        return maxSquare;
    }

    public boolean checkSquare(char[][] matrix, int i, int j, int offset) {
        int iOffset = i + offset;
        int jOffset = j + offset;
        for (int x = i; x <= iOffset; x++) {
            if (matrix[x][jOffset] == '0') {
                return false;
            }
        }
        for (int y = j; y < jOffset; y++) {
            if (matrix[iOffset][y] == '0') {
                return false;
            }
        }
        return true;
    }


    // 二刷（还不会）
    public int maximalSquare_2(char[][] matrix) {
        int maxEdge = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}
