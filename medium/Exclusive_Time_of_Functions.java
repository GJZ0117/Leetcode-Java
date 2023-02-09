package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 636. Exclusive Time of Functions
 */

public class Exclusive_Time_of_Functions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int cur = -1;
        for (String log : logs) {
            String[] strs = log.split(":");
            int index = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);
            if (strs[1].equals("start")) {
                if (!deque.isEmpty()) {
                    ans[deque.peekLast()] += time - cur;
                }
                deque.addLast(index);
                cur = time;
            } else {
                int func = deque.pollLast();
                ans[func] += time - cur + 1;
                cur = time + 1;
            }
        }
        return ans;
    }
}
