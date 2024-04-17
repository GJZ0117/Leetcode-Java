package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 */

public class Remove_Duplicate_Letters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (inStack[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    // 二刷（还不会）
    // https://leetcode.cn/problems/remove-duplicate-letters/solutions/528684/yi-kan-jiu-hui-jiu-chai-shou-ba-shou-jia-miqw/
    public String removeDuplicateLetters_2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] count = new int[26];
        boolean[] exist = new boolean[26];
        // 初始化字母出现次数哈希表
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 该位置字母没有在栈中出现过
            if (!exist[c - 'a']) {
                // 栈不为空 && 栈顶元素字典序列靠后 && 栈顶元素还有剩余出现次数
                while (!stack.isEmpty() && stack.peekLast() > c && count[stack.peekLast() - 'a'] > 0) {
                    // 栈顶出栈 修改exist
                    exist[stack.peekLast() - 'a'] = false;
                    stack.pollLast();
                }
                // 该字符入栈 修改exist
                exist[c - 'a'] = true;
                stack.addLast(c);
            }
            count[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }


    // 三刷
    public String removeDuplicateLetters_3(String s) {
        boolean[] visited = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
