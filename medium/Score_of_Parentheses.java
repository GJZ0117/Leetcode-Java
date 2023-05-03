package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. Score of Parentheses
 */

public class Score_of_Parentheses {
    public int scoreOfParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.offer(String.valueOf(c));
            } else {
                if ("(".equals(stack.peekLast())) {
                    stack.pollLast();
                    stack.offer("1");
                } else {
                    int num = 0;
                    while (!"(".equals(stack.peekLast())) {
                        num += Integer.parseInt(stack.pollLast());
                    }
                    stack.pollLast();
                    stack.offer(String.valueOf(2 * num));
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += Integer.parseInt(stack.pollFirst());
        }
        return ans;
    }
}
