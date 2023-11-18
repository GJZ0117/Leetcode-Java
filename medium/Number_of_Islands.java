package medium;

/**
 * 200. Number of Islands
 */

public class Number_of_Islands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0'}, {'0', '1', '0'}, {'1', '0', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int[] pos = {-1, -1}; //值为1的坐标 pos[0] = row, pos[1] = col
        int ans = 0; //island数量
        findOne(grid, pos); //从grid中找到一个值为'1'的坐标

        while (pos[0] != -1) {
            ans++; //island数加一
            fillIsland(grid, pos[0], pos[1]); //dfs将该island所有'1'改为'2'
            pos[0] = -1; //恢复pos[0] = -1用于while循环判断结束（grid中是否还存在'1'）
            findOne(grid, pos); //找下一个island的'1'
        }

        return ans;
    }

    public static void findOne(char[][] grid, int[] pos) { //从island中找一个值为'1'的坐标
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    pos[0] = i;
                    pos[1] = j;
                    return;
                }
            }
        }
    }

    public static void fillIsland(char[][] grid, int i, int j) { //dfs遍历该island，同时把该island所有的'1'改为'2'表示已遍历过
        grid[i][j] = '2';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') { //上
            fillIsland(grid, i - 1, j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') { //下
            fillIsland(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') { //左
            fillIsland(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') { //右
            fillIsland(grid, i, j + 1);
        }
    }


    // 二刷
    public int numIslands_2(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    change1To2(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    public void change1To2(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '2';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            change1To2(grid, i - 1, j, m, n);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            change1To2(grid, i + 1, j, m, n);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            change1To2(grid, i, j - 1, m, n);
        }
        if (j + 1 < n && grid[i][j + 1] == '1') {
            change1To2(grid, i, j + 1, m, n);
        }
    }
}
