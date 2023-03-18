package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 */

public class Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]) {
                int top = deque.pollLast();
                ans[top] = i - top;
            }
            deque.offer(i);
        }
        return ans;
    }
}
