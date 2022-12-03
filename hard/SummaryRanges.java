package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 352. Data Stream as Disjoint Intervals
 */

class SummaryRanges {
    List<int[]> list = new ArrayList<>();

    public void addNum(int val) {
        if (list.isEmpty()) {
            list.add(new int[]{val, val});
            return;
        }

        // binary search to find a neighbour range
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid)[0] <= val) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int[] cur = list.get(right);

        // val is smaller than current range's start
        if (val < cur[0]) {
            // if val + 1 equals to current range's start, reset current start
            if (val + 1 == cur[0]) {
                cur[0] = val;
            } else {
                // if val is not nearby current range's start, create a new range and add it into list
                list.add(right, new int[]{val, val});
            }
            return;
        }

        // if val is included in current range, do nothing
        if (val >= cur[0] && val <= cur[1]) {
            return;
        }

        // if current range is the last range of list
        if (right == list.size() - 1) {
            //if current range's end + 1 equals to val, update end
            if (cur[1] + 1 == val) {
                cur[1] = val;
            } else {
                //if val is bigger than the last range's end, create a new range and insert it at the end of list
                list.add(new int[]{val, val});
            }
        } else {
            // if current range is not the last range of list
            int[] next = list.get(right + 1);
            // if current range's end + 1 equals to val and next range's start - 1 equals to val, combine two ranges
            if (cur[1] + 1 == val && val == next[0] - 1) {
                cur[1] = next[1];
                list.remove(right + 1);
            } else if (cur[1] + 1 == val) {
                // current range's end + 1 equals to val, update current range's end
                cur[1] = val;
            } else if (next[0] - 1 == val) {
                // next range's start - 1 equals to val, update next range's start
                next[0] = val;
            } else {
                // current val is not nearby any range, create a new range and insert it into list
                list.add(right + 1, new int[]{val, val});
            }
        }
    }

    public int[][] getIntervals() {
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

//Time Limit Exceeded
/*
class SummaryRanges {

    List<Integer> queue;

    public SummaryRanges() {
        queue = new LinkedList<>();
    }

    public void addNum(int value) {
        if (queue.isEmpty()) {
            queue.add(value);
        } else {
            for (int i = 0; i < queue.size(); i++) {
                if (value == queue.get(i)) {
                    return;
                }else if (value < queue.get(i)) {
                    queue.add(i, value);
                    return;
                }
            }
            queue.add(value);
        }
    }

    public int[][] getIntervals() {
        System.out.println(queue);
        List<List<Integer>> ranges = new LinkedList<>();
        int start = queue.get(0);
        int end = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            int cur = queue.get(i);
            if (cur > end + 1) {
                List<Integer> range = new LinkedList<>();
                range.add(start);
                range.add(end);
                ranges.add(range);
                start = cur;
                end = cur;
            } else {
                end = cur;
            }
        }
        List<Integer> range = new LinkedList<>();
        range.add(start);
        range.add(end);
        ranges.add(range);

        int[][] ans = new int[ranges.size()][2];
        for (int i = 0; i < ranges.size(); i++) {
            ans[i][0] = ranges.get(i).get(0);
            ans[i][1] = ranges.get(i).get(1);
        }
        return ans;
    }
}
*/