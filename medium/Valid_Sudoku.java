package medium;

/**
 * 36. Valid Sudoku
 */

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > '0' && board[i][j] <= '9') {
                    if (!isEffect(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isEffect(char[][] board, int i, int j) {
        //check row
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == board[i][j]) {
                System.out.println("check row :" + i + j);
                return false;
            }
        }
        //check col
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == board[i][j]) {
                System.out.println("check col :" + i + j);
                return false;
            }
        }
        //check 3*3 box
        int box_i = (i / 3)*3;
        int box_j = (j / 3)*3;
        for (int x = box_i; x < box_i + 3; x++) {
            for (int y = box_j; y < box_j + 3; y++) {
                if ((board[x][y] == board[i][j]) && (x != i && y != j)) {
                    System.out.println("check box :" + i + j);
                    return false;
                }
            }
        }
        return true;
    }
}
