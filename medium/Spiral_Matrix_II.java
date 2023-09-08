package medium;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 */

public class Spiral_Matrix_II {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] nums : matrix) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int j = 0;
        int cur = 1;

        while (i < n && j < n && cur <= n * n) {
            while (j < n && matrix[i][j] == 0) { //right
                matrix[i][j] = cur;
                cur++;
                j++;
            }
            j--;

            i++;
            while (i < n && matrix[i][j] == 0) { //down
                matrix[i][j] = cur;
                cur++;
                i++;
            }
            i--;

            j--;
            while (j >= 0 && matrix[i][j] == 0) { //left
                matrix[i][j] = cur;
                cur++;
                j--;
            }
            j++;

            i--;
            while (i >= 0 && matrix[i][j] == 0) { //up
                matrix[i][j] = cur;
                cur++;
                i--;
            }
            i++;
            j++;
        }
        return matrix;
    }


    // 二刷
    public int[][] generateMatrix_2(int n) {
        int cur = 1;
        int end = n * n;
        int i = 0;
        int j = 0;
        int[][] matrix = new int[n][n];
        while (cur <= end) {
            while (j < n && matrix[i][j] == 0) {
                matrix[i][j] = cur;
                cur++;
                j++;
            }
            i++;
            j--;

            while (i < n && matrix[i][j] == 0) {
                matrix[i][j] = cur;
                cur++;
                i++;
            }
            i--;
            j--;

            while (j >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = cur;
                cur++;
                j--;
            }
            i--;
            j++;

            while (i >= 0 && matrix[i][j] == 0) {
                matrix[i][j] = cur;
                cur++;
                i--;
            }
            i++;
            j++;
        }
        return matrix;
    }
}
