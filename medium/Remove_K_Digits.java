package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. Remove K Digits
 */

public class Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }

        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
