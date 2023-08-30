package medium;

import java.util.Arrays;

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
        int box_i = (i / 3) * 3;
        int box_j = (j / 3) * 3;
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


    // 二刷
    public boolean isValidSudoku_2(char[][] board) {
        int[] flag = new int[9];
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i, flag)) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (!checkCol(board, j, flag)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSubBox(board, i * 3, j * 3, flag)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRow(char[][] board, int i, int[] flag) {
        for (int j = 0; j < 9; j++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            } else if (flag[c - '1'] != 0) {
                Arrays.fill(flag, 0);
                return false;
            }
            flag[c - '1']++;
        }
        Arrays.fill(flag, 0);
        return true;
    }

    private boolean checkCol(char[][] board, int j, int[] flag) {
        for (int i = 0; i < 9; i++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            } else if (flag[c - '1'] != 0) {
                Arrays.fill(flag, 0);
                return false;
            }
            flag[c - '1']++;
        }
        Arrays.fill(flag, 0);
        return true;
    }

    private boolean checkSubBox(char[][] board, int i, int j, int[] flag) {
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                char c = board[x][y];
                if (c == '.') {
                    continue;
                } else if (flag[c - '1'] != 0) {
                    Arrays.fill(flag, 0);
                    return false;
                }
                flag[c - '1']++;
            }
        }
        Arrays.fill(flag, 0);
        return true;
    }
}
