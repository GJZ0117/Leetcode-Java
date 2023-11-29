package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 227. Basic Calculator II
 */

public class Basic_Calculator_II {

    public static void main(String[] args) {
        String s = "3-5/3-2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                int num = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                i = j - 1;
                numStack.push(num);
            } else if (curChar == '+' || curChar == '-') {
                opStack.push(curChar);
            } else if (curChar == '*' || curChar == '/') {
                int n1 = numStack.pop();
                int n2 = 0;
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    n2 = n2 * 10 + (s.charAt(j) - '0');
                    j++;
                }
                i = j - 1;
                cal(numStack, n1, n2, curChar);
            }
        }
        while (!opStack.isEmpty()) {
            int n1 = numStack.get(0);
            int n2 = numStack.get(1);
            numStack.remove(0);
            numStack.remove(0);
            char op = opStack.get(0);
            opStack.remove(0);
            cal(numStack, n1, n2, op);
        }
        return numStack.pop();
    }

    public static void cal(Stack<Integer> numStack, int n1, int n2, char op) {
        if (op == '+') {
            numStack.add(0, n1 + n2);
        } else if (op == '-') {
            numStack.add(0, n1 - n2);
        } else if (op == '*') {
            numStack.push(n1 * n2);
        } else if (op == '/') {
            numStack.push(n1 / n2);
        }
    }


    // 二刷
    public int calculate_2(String s) {
        Deque<Character> opStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                int num = 0;
                int j = i;
                for (; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
                    num = num * 10 + (s.charAt(j) - '0');
                }
                i = j - 1;
                numStack.addLast(num);
            } else if (curChar == '+' || curChar == '-') {
                opStack.addLast(curChar);
            } else if (curChar == '*' || curChar == '/') {
                int n1 = numStack.removeLast();
                int n2 = 0;
                int j = i + 1;
                for (; j < s.length() && Character.isDigit(s.charAt(j)); j++) {
                    n2 = n2 * 10 + (s.charAt(j) - '0');
                }
                i = j - 1;
                if (curChar == '*') {
                    numStack.addLast(n1 * n2);
                } else {
                    numStack.addLast(n1 / n2);
                }
            }
        }

        while (!opStack.isEmpty()) {
            int n1 = numStack.removeFirst();
            int n2 = numStack.removeFirst();
            char op = opStack.removeFirst();
            if (op == '+') {
                numStack.addFirst(n1 + n2);
            } else if (op == '-') {
                numStack.addFirst(n1 - n2);
            }
        }
        return numStack.removeFirst();
    }
}
