package medium;

import java.util.*;

/**
 * 1042. Flower Planting With No Adjacent
 */

public class Flower_Planting_With_No_Adjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbours.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            neighbours.get(path[0] - 1).add(path[1] - 1);
            neighbours.get(path[1] - 1).add(path[0] - 1);
        }
        int[] ans = new int[n];
        boolean[] flowers = new boolean[5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flowers, false);
            for (int neighbour : neighbours.get(i)) {
                flowers[ans[neighbour]] = true;
            }
            for (int f = 1; f < 5; f++) {
                if (!flowers[f]) {
                    ans[i] = f;
                    break;
                }
            }
        }
        return ans;
    }
}
