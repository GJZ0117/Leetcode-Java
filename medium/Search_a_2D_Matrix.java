package medium;

/**
 * 74. Search a 2D Matrix
 */

public class Search_a_2D_Matrix {

    public static void main(String[] args) {
        int[][] matrix =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 22));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;

        for (int i=0; i<m; i++){ //找到第一次出现的最后一个元素大于target的行
            if (matrix[i][n-1] >= target) {
                row = i;
                break;
            }
        }

        for (int j=0; j<n; j++){ //遍历找到的这行
            if (matrix[row][j] == target){
                return true;
            }
            if (matrix[row][j] >= target) {
                return false;
            }
        }
        return false; //大于矩阵中最大元素
    }

}
