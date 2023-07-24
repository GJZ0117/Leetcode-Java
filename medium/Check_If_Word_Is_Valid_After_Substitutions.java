package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1003. Check If Word Is Valid After Substitutions
 */

public class Check_If_Word_Is_Valid_After_Substitutions {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                stack.add(c);
            } else if (c == 'b') {
                if (stack.isEmpty() || stack.peekLast() != 'a') {
                    return false;
                } else {
                    stack.add(c);
                }
            } else {
                if (stack.isEmpty() || stack.peekLast() != 'b') {
                    return false;
                } else {
                    stack.pollLast();
                    stack.pollLast();
                }
            }
        }
        return stack.isEmpty();
    }
}
