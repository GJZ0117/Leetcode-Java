package medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * 436. Find Right Interval
 */

public class Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            ans[i] = entry == null ? -1 : entry.getValue();
        }
        return ans;
    }
}
