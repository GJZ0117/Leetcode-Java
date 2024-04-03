package hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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


    // 二刷
    // https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/?show=1
    public int longestValidParentheses_2(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.addLast(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peekLast());
                }
            }
        }
        return maxAns;
    }
}
