package easy;

/**
 * 999. Available Captures for Rook
 */

public class Available_Captures_for_Rook {
    int ans = 0;

    public int numRookCaptures(char[][] board) {
        int x;
        int y;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    for (x = i; x >= 0; x--) {
                        if (board[x][j] == 'B') {
                            break;
                        } else if (board[x][j] == 'p') {
                            ans++;
                            break;
                        }
                    }
                    for (x = i; x < 8; x++) {
                        if (board[x][j] == 'B') {
                            break;
                        } else if (board[x][j] == 'p') {
                            ans++;
                            break;
                        }
                    }
                    for (y = j; y >= 0; y--) {
                        if (board[i][y] == 'B') {
                            break;
                        } else if (board[i][y] == 'p') {
                            ans++;
                            break;
                        }
                    }
                    for (y = j; y < 8; y++) {
                        if (board[i][y] == 'B') {
                            break;
                        } else if (board[i][y] == 'p') {
                            ans++;
                            break;
                        }
                    }
                    return ans;
                }
            }
        }
        return ans;
    }
}
