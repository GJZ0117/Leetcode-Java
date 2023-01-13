package easy;

/**
 * 766. Toeplitz Matrix
 */

public class Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // first col
        for (int i = 0; i < m; i++) {
            int num = matrix[i][0];
            int x = i + 1;
            int y = 1;
            while (x < m && y < n) {
                if (!checkIsSame(matrix, x, y, num)) {
                    return false;
                }
                x++;
                y++;
            }
        }

        // first row
        for (int j = 1; j < n; j++) {
            int num = matrix[0][j];
            int x = 1;
            int y = j + 1;
            while (x < m && y < n) {
                if (!checkIsSame(matrix, x, y, num)) {
                    return false;
                }
                x++;
                y++;
            }
        }

        return true;
    }

    public boolean checkIsSame(int[][] matrix, int i, int j, int target) {
        return matrix[i][j] == target;
    }
}
