package medium;

/**
 * 695. Max Area of Island
 */

public class Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        int curArea;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    curArea = searchArea(grid, m, n, i, j);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        return maxArea;
    }

    public int searchArea(int[][] grid, int m, int n, int i, int j) {
        int area = 1;
        grid[i][j] = 2;

        if (i > 0 && grid[i - 1][j] == 1) { // up
            area += searchArea(grid, m, n, i - 1, j);
        }
        if (i < m - 1 && grid[i + 1][j] == 1) { // down
            area += searchArea(grid, m, n, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == 1) { // left
            area += searchArea(grid, m, n, i, j - 1);
        }
        if (j < n - 1 && grid[i][j + 1] == 1) { // right
            area += searchArea(grid, m, n, i, j + 1);
        }

        return area;
    }
}
