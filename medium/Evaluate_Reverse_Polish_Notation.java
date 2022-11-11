package medium;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans;
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                ans = calculate(stack, tokens[i]);
                stack.push(ans);
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return false;
        } else {
            return true;
        }
    }

    public int calculate(Stack<Integer> stack, String token) {
        int second = stack.pop();
        int first = stack.pop();
        if (token.equals("+")) {
            return first + second;
        } else if (token.equals("-")) {
            return first - second;
        } else if (token.equals("*")) {
            return first * second;
        } else {
            return first / second;
        }
    }

}
