package medium;

import java.util.Arrays;
import java.util.List;

/**
 * 539. Minimum Time Difference
 */

public class Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] strs = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
        }
        Arrays.sort(times);
        int minDiff = Math.min(Math.abs(times[times.length - 1] - times[0]), times[0] + 1440 - times[times.length - 1]);
        for (int i = 1; i < timePoints.size(); i++) {
            minDiff = Math.min(minDiff, times[i] - times[i - 1]);
        }
        return minDiff;
    }
}
