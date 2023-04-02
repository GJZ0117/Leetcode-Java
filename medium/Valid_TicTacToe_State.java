package medium;

/**
 * 794. Valid Tic-Tac-Toe State
 */

public class Valid_TicTacToe_State {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        boolean xWin = false;
        boolean oWin = false;
        for (String row : board) {
            if (row.equals("XXX")) {
                xWin = true;
            } else if (row.equals("OOO")) {
                oWin = true;
            }

            for (int i = 0; i < 3; i++) {
                if (row.charAt(i) == 'X') {
                    xCount++;
                } else if (row.charAt(i) == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount < oCount || xCount > oCount + 1) {
            return false;
        }

        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == 'X' && board[1].charAt(j) == 'X' && board[2].charAt(j) == 'X') {
                xWin = true;
            } else if (board[0].charAt(j) == 'O' && board[1].charAt(j) == 'O' && board[2].charAt(j) == 'O') {
                oWin = true;
            }
        }

        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') {
            xWin = true;
        }
        if (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') {
            xWin = true;
        }
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') {
            oWin = true;
        }
        if (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') {
            oWin = true;
        }

        if (xWin && oWin) {
            return false;
        }
        if (xWin && xCount == oCount) {
            return false;
        }
        if (oWin && xCount > oCount) {
            return false;
        }

        return true;

    }
}
