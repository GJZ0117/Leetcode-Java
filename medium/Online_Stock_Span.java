package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. Online Stock Span
 */

public class Online_Stock_Span {
    // https://leetcode.cn/problems/online-stock-span/solution/by-ac_oier-m8g7/
    class StockSpanner {
        Deque<int[]> deque = new ArrayDeque<>();
        int cur = 0;

        public int next(int price) {
            while (!deque.isEmpty() && deque.peekLast()[1] <= price) {
                deque.pollLast();
            }
            int prev = deque.isEmpty() ? -1 : deque.peekLast()[0];
            int ans = cur - prev;
            deque.addLast(new int[]{cur++, price});
            return ans;
        }
    }
}
