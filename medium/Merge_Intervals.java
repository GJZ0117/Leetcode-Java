package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 */

public class Merge_Intervals {

    public static void main(String[] args) {
        int[][] nums = {{1, 4}, {0, 4}};
        nums = merge(nums);
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        boolean flag = false;
        int[] temp;
        for (int i = 0; i < intervals.length; i++) { //采用冒泡排序按照左边界对范围排序
            for (int j = 0; j < intervals.length - 1 - i; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    swap(intervals,j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];
        list.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                list.add(newInterval);
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void swap(int[][] intervals,int j ) {
        int j_begin = intervals[j][0];
        int j_end = intervals[j][1];
        intervals[j][0] = intervals[j+1][0];
        intervals[j][1] = intervals[j+1][1];
        intervals[j+1][0] = j_begin;
        intervals[j+1][1] = j_end;
    }

}
