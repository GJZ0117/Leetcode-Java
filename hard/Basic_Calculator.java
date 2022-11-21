package hard;

import java.util.Stack;

/**
 * 224. Basic Calculator
 */

public class Basic_Calculator {
    public static void main(String[] args) {
        String s = " 1 +  1";
        System.out.println(calculate(s));
    }
    public static int calculate(String s) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        numStack.push(0);
        s = s.replaceAll(" ","");
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                opStack.push(curChar);
            } else if (curChar == ')') {
                while (!opStack.isEmpty()) {
                    char op = opStack.pop();
                    if (op != '(') {
                        cal(numStack, op);
                    } else {
                        break;
                    }
                }
            } else if (curChar == '+' || curChar == '-') {
                if (i > 0 && s.charAt(i - 1) == '(') {
                    numStack.push(0);
                }
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    char op = opStack.pop();
                    cal(numStack, op);
                }
                opStack.push(curChar);
            } else if (Character.isDigit(curChar)) {
                int num = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                numStack.push(num);
                i = j - 1;
            }
        }
        while (!opStack.isEmpty()) {
            char op = opStack.pop();
            cal(numStack, op);
        }
        return numStack.pop();
    }

    public static void cal(Stack<Integer> numStack, char op) {
        if (numStack.isEmpty() || numStack.size() < 2) {
            return;
        }
        int n2 = numStack.pop();
        int n1 = numStack.pop();
        numStack.push(op == '+' ? n1 + n2 : n1 - n2);
    }

}
