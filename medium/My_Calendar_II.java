package medium;

import java.util.*;

/**
 * 731. My Calendar II
 */

public class My_Calendar_II {
    // https://leetcode.cn/problems/my-calendar-ii/solution/yi-fa-jie-nti-by-laughhhh-pll7/
    class MyCalendarTwo {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int cur = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cur += entry.getValue();
                if (cur > 2) {
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}
