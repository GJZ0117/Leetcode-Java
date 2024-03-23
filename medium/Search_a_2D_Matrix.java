package medium;

/**
 * 74. Search a 2D Matrix
 */

public class Search_a_2D_Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 22));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;

        for (int i = 0; i < m; i++) { // 找到第一次出现的最后一个元素大于target的行
            if (matrix[i][n - 1] >= target) {
                row = i;
                break;
            }
        }

        for (int j = 0; j < n; j++) { // 遍历找到的这行
            if (matrix[row][j] == target) {
                return true;
            }
            if (matrix[row][j] >= target) {
                return false;
            }
        }
        return false; // 大于矩阵中最大元素
    }


    // 二刷
    public boolean searchMatrix_2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m - 1;
        int midRow = 0;
        while (startRow <= endRow) {
            midRow = startRow + ((endRow - startRow) >> 1);
            if (matrix[midRow][0] > target) {
                endRow = midRow - 1;
            } else if (matrix[midRow][n - 1] < target) {
                startRow = midRow + 1;
            } else {
                break;
            }
        }
        int startCol = 0;
        int endCol = n - 1;
        int midCol;
        while (startCol <= endCol) {
            midCol = startCol + ((endCol - startCol) >> 1);
            if (matrix[midRow][midCol] > target) {
                endCol = midCol - 1;
            } else if (matrix[midRow][midCol] < target) {
                startCol = midCol + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    // 三刷
    public boolean searchMatrix_3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m - 1;
        int midRow = 0;
        while (startRow <= endRow) {
            midRow = startRow + (endRow - startRow) / 2;
            if (matrix[midRow][0] > target) {
                endRow = midRow - 1;
            } else if (matrix[midRow][n - 1] < target) {
                startRow = midRow + 1;
            } else {
                break;
            }
        }
        int startCol = 0;
        int endCol = n - 1;
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            if (matrix[midRow][midCol] > target) {
                endCol = midCol - 1;
            } else if (matrix[midRow][midCol] < target) {
                startCol = midCol + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
