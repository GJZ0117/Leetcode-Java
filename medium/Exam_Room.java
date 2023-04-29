package medium;

import java.util.List;
import java.util.TreeSet;

/**
 * 855. Exam Room
 */

public class Exam_Room {
    class ExamRoom {
        TreeSet<Integer> set;
        int n;
        public ExamRoom(int n) {
            this.n = n;
            set = new TreeSet<>();
        }
        public int seat() {
            if (set.size() == 0) {set.add(0); return 0;}
            int pre = set.first(), ans = set.first(), idx = 0;
            for (int x : set) {
                if (ans < (x - pre) / 2) {
                    ans = (x - pre) / 2;
                    idx = (x + pre) / 2;
                }
                pre = x;
            }
            int d = n - 1 - set.last();
            if (ans < d) {ans = d; idx = n - 1;}
            set.add(idx);
            return idx;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }
}
