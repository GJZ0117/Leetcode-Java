package hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1944. Number of Visible People in a Queue
 */

public class Number_of_Visible_People_in_a_Queue {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peekLast()) {
                ans[i]++;
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            stack.addLast(heights[i]);
        }
        return ans;
    }
}
