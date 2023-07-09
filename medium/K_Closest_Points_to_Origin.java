package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 973. K Closest Points to Origin
 */

public class K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            if (map.containsKey(dist)) {
                map.get(dist).add(points[i]);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(points[i]);
                map.put(dist, list);
            }
        }

        int index = 0;
        while (index < k) {
            int key = map.firstKey();
            List<int[]> list = map.get(key);
            for (int i = 0; i < list.size() && index < k; i++, index++) {
                res[index][0] = list.get(i)[0];
                res[index][1] = list.get(i)[1];
            }
            map.remove(key);
        }
        return res;
    }
}
