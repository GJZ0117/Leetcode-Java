package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 566. Reshape the Matrix
 */

public class Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat[0].length * mat.length) {
            return mat;
        }

        int[][] matrix = new int[r][c];
        List<Integer> list = new ArrayList<>();
        int index = 0;

        for (int[] nums : mat) {
            for (int num : nums) {
                list.add(num);
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                matrix[i][j] = list.get(index);
                index++;
            }
        }

        return matrix;
    }
}
