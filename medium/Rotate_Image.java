package medium;

public class Rotate_Image {

    /**
     * https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
     * 先整体上下翻转，再以主对角线为对称轴镜像翻转
     */
    public void rotate(int[][] matrix) {
        reverse(matrix); //上下翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j); //镜像翻转（交换）
            }
        }
    }

    public static void reverse(int[][] matrix) {
        int[] temp;
        int i = 0;
        int j = matrix.length - 1;
        while (i < j) {
            temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }

    public static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
