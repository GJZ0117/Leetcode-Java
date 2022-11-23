package medium;

/**
 * 240. Search a 2D Matrix II
 */

public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                row[i] = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] <= target && matrix[m - 1][j] >= target) {
                col[j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (!row[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (!col[j]) {
                    continue;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
