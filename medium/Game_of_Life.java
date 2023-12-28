package medium;

/**
 * 289. Game of Life
 */

public class Game_of_Life {

    /**
     * rule 1: previous live, now die : -1
     * rule 2: previous live, now live: 1
     * rule 3: previous live, now die : -1
     * rule 4: previous die, now live : 2
     */

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbours = checkNeighbours(board, i, j, m, n);
                if (board[i][j] == 1 && (liveNeighbours < 2 || liveNeighbours > 3)) { // rule 1 and rule 3
                    board[i][j] = -1;
                } else if (board[i][j] == 1 && (liveNeighbours == 2 || liveNeighbours == 3)) { // rule 2
                    board[i][j] = 1;
                } else if (board[i][j] == 0 && liveNeighbours == 3) { // rule 4
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }

    public int checkNeighbours(int[][] board, int i, int j, int m, int n) {
        int liveCells = 0;
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }
                int x = xOffset + i;
                int y = yOffset + j;
                if ((x >= 0 && x < m) && (y >= 0 && y < n)) {
                    if (Math.abs(board[x][y]) == 1) {
                        liveCells++;
                    }
                }
            }
        }
        return liveCells;
    }


    // 二刷
    public void gameOfLife_2(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbourCount = liveNeighbour(board, i, j, m, n);
                if (board[i][j] == 1 && (liveNeighbourCount < 2 || liveNeighbourCount > 3)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 1 && (liveNeighbourCount == 2 || liveNeighbourCount == 3)) {
                    board[i][j] = 1;
                } else if (board[i][j] == 0 && liveNeighbourCount == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int liveNeighbour(int[][] board, int i, int j, int m, int n) {
        int liveNeighbourCount = 0;
        int[] offset = {-1, 0, 1};
        for (int xOffset : offset) {
            for (int yOffset : offset) {
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }
                int x = i + xOffset;
                int y = j + yOffset;
                if (x < 0 || x >= m || y < 0 || y >=n) {
                    continue;
                }
                if (board[x][y] == 1 || board[x][y] == -1) {
                    liveNeighbourCount++;
                }
            }
        }
        return liveNeighbourCount;
    }
}
