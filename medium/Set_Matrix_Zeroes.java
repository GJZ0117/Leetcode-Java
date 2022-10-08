package medium;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 */

public class Set_Matrix_Zeroes {

    public static void main(String[] args) {
        int[][] matrix = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        setZeroes(matrix);
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line));
        }
    }


    /**
     * https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
     * 用一个变量col0记录第0列里有没有0，如果有col0=0，如果没有col0=1；然后从左上到右下依次遍历数组，如果[i][j]位置为0，把[i][0]=0，[0][j]=0，遍历完后再从右下到左上遍历数组，如果[i][0]=0或[0][j]=0，就把[i][j]=0，每遍历完一行判断一次col0是否为0，如果为0就把本次遍历的行第一个元素置为0
     */
    public static void setZeroes(int[][] matrix) {
        int col0 = 1; //用于记录第0列中是否存在0，存在col0=0
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) { //第0列中存在0
                col0 = 0;
            }
            for (int j = 1; j < n; j++) { //第0列记录该行是否存在0，故j从1开始
                if (matrix[i][j] == 0) { //[i][j]为0，把该列第0个元素和该行第0个元素设为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) { //第0列用于记录0元素是否存在于本行，故j最小值为1
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { //元素所在列或行的第0个元素为0
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) { //每遍历完一行检查col0是否为0，为0的话需要将该行第0个元素置为0
                matrix[i][0] = 0;
            }
        }
    }

}
