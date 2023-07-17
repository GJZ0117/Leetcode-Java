package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 */

public class Interval_List_Intersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][2];
        }
        List<int[]> list = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstList.length && secondIndex < secondList.length) {
            int left = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            int right = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);
            if (left <= right) {
                list.add(new int[]{left, right});
            }
            if (firstList[firstIndex][1] < secondList[secondIndex][1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
