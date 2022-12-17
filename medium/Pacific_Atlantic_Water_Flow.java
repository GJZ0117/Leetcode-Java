package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 */

public class Pacific_Atlantic_Water_Flow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // record the area which pacific ocean can reach
        boolean[][] pacificArea = new boolean[m][n];
        // record the area which atlantic ocean can reach
        boolean[][] atlanticArea = new boolean[m][n];
        // initialize four border
        for (int i = 0; i < m; i++) {
            pacificArea[i][0] = true;
            atlanticArea[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificArea[0][j] = true;
            atlanticArea[m - 1][j] = true;
        }

        // visited array is used to record the box which had been visited
        boolean[][] visited = new boolean[m][n];
        // use dfs to find the area which pacific ocean can reach
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificArea[i][j]) {
                    dfs(heights, m, n, pacificArea, visited, i, j);
                }
            }
        }

        visited = new boolean[m][n];
        // use dfs to find the area which atlantic ocean can reach
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (atlanticArea[i][j]) {
                    dfs(heights, m, n, atlanticArea, visited, i, j);
                }
            }
        }

        List<List<Integer>> lists = new ArrayList<>();
        // find the boxes which both pacific ocean and atlantic ocean can reach
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificArea[i][j] && atlanticArea[i][j]) {
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public void dfs(int[][] heights, int m, int n, boolean[][] area, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j] && heights[i][j] <= heights[i - 1][j]) {
            area[i - 1][j] = true;
            dfs(heights, m, n, area, visited, i - 1, j);
        }
        if (i < m - 1 && !visited[i + 1][j] && heights[i][j] <= heights[i + 1][j]) {
            area[i + 1][j] = true;
            dfs(heights, m, n, area, visited, i + 1, j);
        }
        if (j > 0 && !visited[i][j - 1] && heights[i][j] <= heights[i][j - 1]) {
            area[i][j - 1] = true;
            dfs(heights, m, n, area, visited, i, j - 1);
        }
        if (j < n - 1 && !visited[i][j + 1] && heights[i][j] <= heights[i][j + 1]) {
            area[i][j + 1] = true;
            dfs(heights, m, n, area, visited, i, j + 1);
        }
    }
}
