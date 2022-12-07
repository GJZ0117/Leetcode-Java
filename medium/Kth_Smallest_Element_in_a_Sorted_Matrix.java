package medium;

import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 */

public class Kth_Smallest_Element_in_a_Sorted_Matrix {

    /**
     * eg: matrix=[[1,5,9],[10,11,13],[12,13,15]], k = 5
     *      k = 5          k = 4         k = 3          k = 2           k = 1
     *      (1)  5  9     (1)  (5) 9    (1)  (5) (9)    (1)  (5)  (9)   (1)  (5)  (9)
     *      (10) 11 13    (10) 11 13    (10) 11 12      (10)  11  12    (10) (11) 12
     *      (12) 13 15    (12) 13 15    (12) 13 15      (12)  13  15    (12)  13  15
     *
     * heap [1,10,12]   [5,10,12]       [9,10,12]       [10,12]         [11,12]
     * pop  1           5               9               10              11
     * add  5           9                               11              12
     */

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{i, 0});
        }
        int[] pos = null;
        while (k > 0) {
            pos = heap.poll();
            int i = pos[0];
            int j = pos[1];
            if (j < n - 1) {
                heap.offer(new int[]{i, j + 1});
            }
            k--;
        }
        return matrix[pos[0]][pos[1]];
    }
}
