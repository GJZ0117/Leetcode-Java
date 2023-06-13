package medium;

import java.util.*;

/**
 * 939. Minimum Area Rectangle
 */

public class Minimum_Area_Rectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(x)) {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(x, list);
            } else {
                map.get(x).add(y);
            }
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> lastX = new HashMap<>();
        for (int x : map.keySet()) {
            List<Integer> list = map.get(x);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                int y1 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    int y2 = list.get(j);
                    // 因为x和y的最大值都是40000，所以state = x*40001+y能唯一确定一个(x, y)。证明就是x = state / 40001, y = state % 40001
                    int code = 40001 * y1 + y2;
                    if (lastX.containsKey(code)) {
                        ans = Math.min(ans, (x - lastX.get(code)) * (y2 - y1));
                    }
                    lastX.put(code, x);
                }
            }
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
