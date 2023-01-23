package medium;

/**
 * 529. Minesweeper
 */

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {

        int m = board.length;
        int n = board[0].length;

        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        int adjacentMine = checkAdjacentMine(board, m, n, row, col);
        if (adjacentMine != 0) {
            board[row][col] = (char) ('0' + adjacentMine);
            return board;
        }

        board[row][col] = 'B';
        dfs(board, m, n, row - 1, col);
        dfs(board, m, n, row + 1, col);
        dfs(board, m, n, row, col - 1);
        dfs(board, m, n, row, col + 1);
        dfs(board, m, n, row - 1, col - 1);
        dfs(board, m, n, row - 1, col + 1);
        dfs(board, m, n, row + 1, col - 1);
        dfs(board, m, n, row + 1, col + 1);
        return board;
    }

    public int checkAdjacentMine(char[][] board, int m, int n, int row, int col) {
        int adjacentMine = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            if (i < 0 || i >= m) {
                continue;
            }
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if ((j >= 0 && j < n) && board[i][j] == 'M') {
                    adjacentMine++;
                }
            }
        }
        return adjacentMine;
    }

    public void dfs(char[][] board, int m, int n, int row, int col) {
        if ((row >= 0 && row < m && col >= 0 && col < n) && (board[row][col] != 'M' && board[row][col] != 'B')) {
            int adjacentMine = checkAdjacentMine(board, m, n, row, col);
            System.out.println(row + " " + col + " " + adjacentMine);
            if (adjacentMine == 0) {
                board[row][col] = 'B';
                dfs(board, m, n, row - 1, col);
                dfs(board, m, n, row + 1, col);
                dfs(board, m, n, row, col - 1);
                dfs(board, m, n, row, col + 1);
                dfs(board, m, n, row - 1, col - 1);
                dfs(board, m, n, row - 1, col + 1);
                dfs(board, m, n, row + 1, col - 1);
                dfs(board, m, n, row + 1, col + 1);
            } else {
                board[row][col] = (char) ('0' + adjacentMine);
            }
        }
    }
}
