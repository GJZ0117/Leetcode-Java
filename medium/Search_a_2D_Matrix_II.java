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


    // 二刷
    public boolean searchMatrix_2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        break;
                    }
                }
            }
        }

        return false;
    }


    // 三刷
    public boolean searchMatrix_3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                int left = 0;
                int right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] > target) {
                        right = mid - 1;
                    } else if (matrix[i][mid] < target) {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
