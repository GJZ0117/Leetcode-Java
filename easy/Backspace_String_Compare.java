package easy;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 */

public class Backspace_String_Compare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("abcd", "bbcd"));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        traverseString(stackS, s);
        traverseString(stackT, t);
        if (stackS.size() != stackT.size()) {
            return false;
        }
        int times = stackS.size();
        for (int i = 0; i < times; i++) {
            char charS = stackS.pop();
            char charT = stackT.pop();
            if (charS != charT) {
                return false;
            }

        }
        return true;

    }

    public static void traverseString(Stack<Character> stack, String str) {
        for (Character c : str.toCharArray()) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else if (c != '#') {
                stack.push(c);
            }
        }
    }
}
