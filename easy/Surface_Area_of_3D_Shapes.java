package easy;

/**
 * 892. Surface Area of 3D Shapes
 */

public class Surface_Area_of_3D_Shapes {
    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cubeNum = 0;
        int adjacentFace = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                cubeNum += grid[i][j];
                adjacentFace += 2 * (grid[i][j] - 1);
                if (i > 0) {
                    adjacentFace += 2 * Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (j < n - 1) {
                    adjacentFace += 2 * Math.min(grid[i][j], grid[i][j + 1]);
                }
            }
        }
        return cubeNum * 6 - adjacentFace;
    }
}
