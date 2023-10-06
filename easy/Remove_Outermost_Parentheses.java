package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1021. Remove Outermost Parentheses
 */

public class Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (deque.size() > 0) {
                    sb.append(c);
                }
                deque.addLast(c);
            } else {
                deque.removeLast();
                if (deque.size() > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
