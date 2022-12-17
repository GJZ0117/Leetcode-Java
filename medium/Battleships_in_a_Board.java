package medium;

/**
 * 419. Battleships in a Board
 */

public class Battleships_in_a_Board {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, m, n, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] board, int m, int n, int i, int j) {
        board[i][j] = 'Y';
        if (i > 0 && board[i - 1][j] == 'X') {
            dfs(board, m, n, i - 1, j);
        }
        if (i < m - 1 && board[i + 1][j] == 'X') {
            dfs(board, m, n, i + 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'X') {
            dfs(board, m, n, i, j - 1);
        }
        if (j < n - 1 && board[i][j + 1] == 'X') {
            dfs(board, m, n, i, j + 1);
        }
    }

}
