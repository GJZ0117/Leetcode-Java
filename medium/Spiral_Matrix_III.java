package medium;

/**
 * 885. Spiral Matrix III
 */

public class Spiral_Matrix_III {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int index = 1;
        int total = rows * cols;
        int row = 1;
        int col = 1;
        res[0][0] = rStart;
        res[0][1] = cStart;
        boolean flag;
        while (index < total) {
            for (int i = 1; i <= row; i++) {
                flag = check(res, index, rows, cols, rStart, ++cStart);
                if (flag) {
                    index++;
                }
            }
            row++;
            for (int i = 1; i <= col; i++) {
                flag = check(res, index, rows, cols, ++rStart, cStart);
                if (flag) {
                    index++;
                }
            }
            col++;
            for (int i = 1; i <= row; i++) {
                flag = check(res, index, rows, cols, rStart, --cStart);
                if (flag) {
                    index++;
                }
            }
            row++;
            for (int i = 1; i <= col; i++) {
                flag = check(res, index, rows, cols, --rStart, cStart);
                if (flag) {
                    index++;
                }
            }
            col++;
        }
        return res;
    }

    private boolean check(int[][] res, int index, int rows, int cols, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            res[index][0] = x;
            res[index][1] = y;
            return true;
        }
        return false;
    }
}
