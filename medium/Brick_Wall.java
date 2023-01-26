package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall
 */

public class Brick_Wall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalRows = wall.size();
        for (List<Integer> row : wall) {
            int curSum = 0;
            for (int pos : row) {
                curSum += pos;
                map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            }
            map.remove(curSum);
        }
        int crossMaxRows = 0;
        for (int row : map.values()) {
            crossMaxRows = Math.max(crossMaxRows, row);
        }
        return totalRows - crossMaxRows;
    }
}
