package medium;

/**
 * 435. Non-overlapping Intervals
 */

public class Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        sortByRightSide(intervals, 0, intervals.length - 1);
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public void sortByRightSide(int[][] intervals, int low, int high) {
        int[] temp;
        int i = low;
        int j = high;
        if (low < high) {
            temp = intervals[low];
            while (i < j) {
                while (j > i && intervals[j][1] >= temp[1]) {
                    j -= 1;
                }
                if (i < j) {
                    intervals[i] = intervals[j];
                    i++;
                }
                while (i < j && intervals[i][1] < temp[1]) {
                    i += 1;
                }
                if (i < j) {
                    intervals[j] = intervals[i];
                    j -= 1;
                }
            }

            intervals[i] = temp;
            sortByRightSide(intervals, low, i - 1);
            sortByRightSide(intervals, i + 1, high);
        }
    }
}
