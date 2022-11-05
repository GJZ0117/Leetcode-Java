package medium;

/**
 * 130. Surrounded Regions
 */

public class Surrounded_Regions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') { // the first row
                changeNextToBoardO(board, i, 0);
            }
            if (board[i][n - 1] == 'O') { // the last row
                changeNextToBoardO(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') { // the first line
                changeNextToBoardO(board, 0, j);
            }
            if (board[m - 1][j] == 'O') { // the last line
                changeNextToBoardO(board, m - 1, j);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void changeNextToBoardO(char[][] board, int i, int j) {
        board[i][j] = 'N';
        if (i > 0 && board[i - 1][j] == 'O') { // up
            changeNextToBoardO(board, i - 1, j);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') { // down
            changeNextToBoardO(board, i + 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'O') { // left
            changeNextToBoardO(board, i, j - 1);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') { //right
            changeNextToBoardO(board, i, j + 1);
        }
    }

}
