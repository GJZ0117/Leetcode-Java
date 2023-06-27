package medium;

import java.util.Arrays;

/**
 * 957. Prison Cells After N Days
 */

public class Prison_Cells_After_N_Days {
    public int[] prisonAfterNDays(int[] cells, int n) {
        n = n % 14;
        if (n == 0) {
            n = 14;
        }
        int[] newStatus = new int[cells.length];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                newStatus[j] = cells[j - 1] ^ cells[j + 1] ^ 1;
            }
            cells = Arrays.copyOf(newStatus, cells.length);
        }
        return newStatus;
    }
}
