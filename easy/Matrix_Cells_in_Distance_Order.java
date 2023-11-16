package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1030. Matrix Cells in Distance Order
 */

public class Matrix_Cells_in_Distance_Order {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        boolean[][] matrix = new boolean[rows][cols];
        Deque<int[]> deque = new ArrayDeque<>();
        int index = 0;
        deque.addLast(new int[]{rCenter, cCenter});
        matrix[rCenter][cCenter] = true;
        while (!deque.isEmpty()) {
            int[] pos = deque.pollFirst();
            res[index++] = pos;
            int x = pos[0];
            int y = pos[1];
            if (x - 1 >= 0 && !matrix[x - 1][y]) {
                deque.addLast(new int[]{x - 1, y});
                matrix[x - 1][y] = true;
            }
            if (x + 1 < rows && !matrix[x + 1][y]) {
                deque.addLast(new int[]{x + 1, y});
                matrix[x + 1][y] = true;
            }
            if (y - 1 >= 0 && !matrix[x][y - 1]) {
                deque.addLast(new int[]{x, y - 1});
                matrix[x][y - 1] = true;
            }
            if (y + 1 < cols && !matrix[x][y + 1]) {
                deque.addLast(new int[]{x, y + 1});
                matrix[x][y + 1] = true;
            }
        }
        return res;
    }
}
