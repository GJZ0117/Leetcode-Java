package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 933. Number of Recent Calls
 */

public class Number_of_Recent_Calls {
    class RecentCounter {

        List<Integer> list;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);
            int ans = 0;
            int begin = Math.max(t - 3000, 0);
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) < begin) {
                    break;
                }
                ans++;
            }
            return ans;
        }
    }
}
