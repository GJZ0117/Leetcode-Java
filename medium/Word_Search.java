package medium;

/**
 * 79. Word Search
 */

public class Word_Search {

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCESEEEFS";
        char[][] board = {{'b', 'a', 'b'}, {'b', 'b', 'a'}, {'b', 'b', 'b'}};
        String word = "ab";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean isMatch;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { //遍历board找到word中第一个字符的坐标
                if (board[i][j] == word.charAt(0)) {
                    int[][] flag = new int[m][n]; //初始化flag数组为0用于记录dfs过程中走过的路径
                    StringBuilder sb = new StringBuilder(); //用于记录dfs过程中经过的字符
                    isMatch = search(board, word, flag, sb, i, j, 0); //dfs匹配word
                    if (isMatch) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean search(char[][] board, String word, int[][] flag, StringBuilder sb, int i, int j, int curIndex) {
        sb.append(board[i][j]); //sb中填入当前坐标的字符
        flag[i][j] = 1; //flag数组中该坐标设为1表示已经用过该位置的字符
        boolean up, down, left, right; //用于记录上下左右四个方向上dfs的结果

        if (sb.length() == word.length()) { //sb的长度和word长度相等时表示匹配成功返回true
            return true;
        }

        //上下左右四个方向依次dfs匹配word中下一个位置的字符
        if (i - 1 >= 0 && flag[i - 1][j] == 0 && board[i - 1][j] == word.charAt(curIndex + 1)) {
            up = search(board, word, flag, sb, i - 1, j, curIndex + 1);
            if (up) {
                return true;
            }
        }
        if (i + 1 < board.length && flag[i + 1][j] == 0 && board[i + 1][j] == word.charAt(curIndex + 1)) {
            down = search(board, word, flag, sb, i + 1, j, curIndex + 1);
            if (down) {
                return true;
            }
        }
        if (j - 1 >= 0 && flag[i][j - 1] == 0 && board[i][j - 1] == word.charAt(curIndex + 1)) {
            left = search(board, word, flag, sb, i, j - 1, curIndex + 1);
            if (left) {
                return true;
            }
        }
        if (j + 1 < board[0].length && flag[i][j + 1] == 0 && board[i][j + 1] == word.charAt(curIndex + 1)) {
            right = search(board, word, flag, sb, i, j + 1, curIndex + 1);
            if (right) {
                return true;
            }
        }

        //匹配失败恢复flag，将该坐标所对应的值设为0表示未使用过，并从sb中移除该字符
        flag[i][j] = 0;
        sb.delete(sb.length() - 1, sb.length());
        return false;
    }


    // 二刷
    public boolean exist_2(char[][] board, String word) {
        boolean isFound = false;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m && !isFound; i++) {
            for (int j = 0; j < n && !isFound; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isFound = search(board, m, n, i, j, word, 0);
                }
            }
        }

        return isFound;
    }

    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private boolean search(char[][] board, int m, int n, int x, int y, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        } else if (board[x][y] != word.charAt(wordIndex)) {
            return false;
        }
        board[x][y] = (char) (board[x][y] - 65);

        int searchDirectionNum = 0;

        for (int[] direction : directions) {
            int i = x + direction[0];
            int j = y + direction[1];
            if (i < 0 || i >= m || j < 0 || j >= n) {
                continue;
            } else {
                ++searchDirectionNum;
                if (search(board, m, n, i, j, word, wordIndex + 1)) {
                    board[x][y] = (char) (board[x][y] + 65);
                    return true;
                }
            }
        }
        board[x][y] = (char) (board[x][y] + 65);
        return searchDirectionNum == 0 && wordIndex == word.length() - 1;
    }
}
