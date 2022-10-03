package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 32. Longest Valid Parentheses
 */

public class Longest_Valid_Parentheses {

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if ("".equals(s)) {
            return 0;
        }
        List<Integer> stack = new ArrayList<>();
        int maxLen = 0;
        int i = 0;
        int strLen = s.length();
        while (i < strLen) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.get(stack.size() - 1)) == '(') {
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.add(i);
                    }
                } else {
                    stack.add(i);
                }
            }
            i++;
        }

        if (stack.isEmpty()) {
            return strLen;
        } else {
            int a = strLen, b = 0;
            while (!stack.isEmpty()) {
                b = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                maxLen = Math.max(maxLen, a - b - 1);
                a = b;
            }
            maxLen = Math.max(maxLen, a);
        }

        return maxLen;
    }
}
