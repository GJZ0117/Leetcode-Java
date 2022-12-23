package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 */

public class Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distance = x * x + y * y;
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int val : map.values()) {
                ans += val * (val - 1);
            }
        }
        return ans;
    }
}
