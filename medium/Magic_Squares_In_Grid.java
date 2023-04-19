package medium;

/**
 * 840. Magic Squares In Grid
 */

public class Magic_Squares_In_Grid {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (magic(grid[i][j], grid[i][j + 1], grid[i][j + 2], grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2], grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean magic(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] f = new int[16];
        f[i]++;
        f[i1]++;
        f[i2]++;
        f[i3]++;
        f[i4]++;
        f[i5]++;
        f[i6]++;
        f[i7]++;
        f[i8]++;
        for (int x = 1; x < 10; x++) {
            if (f[x] != 1) {
                return false;
            }
        }
        return (i + i1 + i2 == 15 && i3 + i4 + i5 == 15 && i6 + i7 + i8 == 15 && i + i3 + i6 == 15 && i1 + i4 + i7 == 15 && i2 + i5 + i8 == 15 && i + i4 + i8 == 15 && i2 + i4 + i6 == 15);
    }
}
