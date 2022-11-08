package hard;

/**
 * 37. Sudoku Solver
 */

public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char cur = '1'; cur <= '9'; cur++) {
                        if (check(board, i, j, cur)) {
                            board[i][j] = cur;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int i, int j, char cur) {
        for (int x = 0; x < 9; x++) {
            if (x != i && board[x][j] == cur) {
                return false;
            }
        }

        for (int y = 0; y < 9; y++) {
            if (y != j && board[i][y] == cur) {
                return false;
            }
        }

        int box_i = (i / 3) * 3;
        int box_j = (j / 3) * 3;
        for (int x = box_i; x < box_i + 3; x++) {
            for (int y = box_j; y < box_j + 3; y++) {
                if (x != i && y != j && board[x][y] == cur) {
                    return false;
                }
            }
        }

        return true;
    }
}
