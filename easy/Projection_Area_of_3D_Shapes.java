package easy;

/**
 * 883. Projection Area of 3D Shapes
 */

public class Projection_Area_of_3D_Shapes {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int xy = 0;
        int xz = 0;
        int yz = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    xy++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int curMaxXZ = 0;
            for (int j = 0; j < n; j++) {
                curMaxXZ = Math.max(curMaxXZ, grid[i][j]);
            }
            xz += curMaxXZ;
        }

        for (int j = 0; j < n; j++) {
            int curMaxYZ = 0;
            for (int i = 0; i < m; i++) {
                curMaxYZ = Math.max(curMaxYZ, grid[i][j]);
            }
            yz += curMaxYZ;
        }

        return xy + xz + yz;
    }
}
