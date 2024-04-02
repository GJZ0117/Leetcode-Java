package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 921. Minimum Add to Make Parentheses Valid
 */

public class Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() == '(' && c == ')') {
                deque.removeLast();
            } else {
                deque.add(c);
            }
        }
        return deque.size();
    }


    // 二刷
    public int minAddToMakeValid_2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.addLast('(');
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pollLast();
                }
            }
        }
        return count + stack.size();
    }
}
