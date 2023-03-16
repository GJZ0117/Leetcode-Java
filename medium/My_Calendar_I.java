package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. My Calendar I
 */

public class My_Calendar_I {
    class MyCalendar {
        List<int[]> list = new ArrayList<>();

        public boolean book(int start, int end) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (start >= list.get(i)[1] || end <= list.get(i)[0]) {
                    continue;
                } else {
                    return false;
                }
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
}
