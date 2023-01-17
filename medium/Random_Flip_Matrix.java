package medium;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 519. Random Flip Matrix
 */

public class Random_Flip_Matrix {
    class Solution {

        Random random;
        int m;
        int n;
        int border;
        Set<Integer> set;

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            border = m * n;
            random = new Random();
            set = new HashSet<>();
        }

        public int[] flip() {
            int pos = random.nextInt(border);
            while (set.contains(pos)) {
                pos = random.nextInt(border);
            }
            set.add(pos);
            int row = pos / n;
            int col = pos % n;
            return new int[]{row, col};
        }

        public void reset() {
            set.clear();
        }
    }
}
