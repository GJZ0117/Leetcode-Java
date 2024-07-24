package medium;

import java.util.ArrayList;
import java.util.List;

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
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') { // right
            changeNextToBoardO(board, i, j + 1);
        }
    }


    // 二刷

    List<int[]> edgeOPos = new ArrayList<>();

    public void solve_2(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                convertEdgeOtoZ(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                convertEdgeOtoZ(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                convertEdgeOtoZ(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                convertEdgeOtoZ(board, m - 1, j);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int[] pos : edgeOPos) {
            board[pos[0]][pos[1]] = 'O';
        }
    }

    private void convertEdgeOtoZ(char[][] board, int x, int y) {
        board[x][y] = 'Z';
        edgeOPos.add(new int[]{x, y});
        if (x - 1 >= 0 && board[x - 1][y] == 'O') {
            convertEdgeOtoZ(board, x - 1, y);
        }
        if (x + 1 < board.length && board[x + 1][y] == 'O') {
            convertEdgeOtoZ(board, x + 1, y);
        }
        if (y - 1 >= 0 && board[x][y - 1] == 'O') {
            convertEdgeOtoZ(board, x, y - 1);
        }
        if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
            convertEdgeOtoZ(board, x, y + 1);
        }
    }


    // 三刷
    public void solve_3(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, directions, i, 0, m, n);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, directions, i, n - 1, m, n);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, directions, 0, j, m, n);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, directions, m - 1, j, m, n);
            }
        }

        for (int i = 0; i < m; i++) System.out.println(board[i]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] directions, int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O') {
            board[i][j] = 'z';
            for (int idx = 0; idx < 4; idx++) {
                int x = i + directions[idx][0];
                int y = j + directions[idx][1];
                dfs(board, directions, x, y, m, n);
            }
        }
    }
}
