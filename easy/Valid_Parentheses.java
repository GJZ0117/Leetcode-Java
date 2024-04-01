package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 20. Valid Parentheses
 */

public class Valid_Parentheses {

    public static void main(String[] args) {
        String s = "([))";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        char c;
        int i = 0; // 遍历字符串s
        stack.add(s.charAt(i++)); // 进栈
        while (i != s.length()) {
            c = s.charAt(i);
            if (check(c) == 0) { // 当前遍历到的字符为左括号，进栈
                stack.add(c);
            } else { // 当前遍历到的字符为右括号
                if (stack.size() == 0) { // 栈为空，没有能匹配的左括号
                    return false;
                }
                char top = stack.get(stack.size() - 1); // 栈非空，取出栈顶字符与当前字符做比较
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // 不匹配
                }
                stack.remove(stack.size() - 1); // 匹配成功栈顶元素出栈
            }
            i++; // 遍历下一个字符
        }

        if (stack.isEmpty()) { // 栈为空说明整个字符串遍历完后都能匹配
            return true;
        }
        return false;
    }

    public static int check(char c) { // 判断传入的字符是左括号还是右括号
        if (c == '(' || c == '[' || c == '{') {
            return 0;
        } else {
            return 1;
        }
    }


    // 二刷
    public boolean isValid_2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (!stack.isEmpty()) {
                    Character top = stack.pollLast();
                    if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
