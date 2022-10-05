package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */

public class Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        int totalNum = m * n;

        int i = 0;
        int j = 0;

        while (totalNum > 0) {
            while (j < n && temp[i][j] != 0) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                j++;
            }
            while (i < m && temp[i][j] != 0) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                i++;
            }
            while (j >= 0 && temp[i][j] != 0) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                j--;
            }
            while (i >= 0 && temp[i][j] != 0) {
                ans.add(matrix[i][j]);
                temp[i][j] = 1;
                totalNum--;
                i--;
            }
        }

        return ans;
    }

}
