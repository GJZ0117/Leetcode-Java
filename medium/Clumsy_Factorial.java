package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1006. Clumsy Factorial
 */

public class Clumsy_Factorial {
    public int clumsy(int n) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> optionStack = new ArrayDeque<>();
        char[] options = {'*', '/', '+', '-'};
        int optionIndex = 0;
        numStack.add(n);
        for (int i = n - 1; i >= 1; i--) {
            char option = options[optionIndex];
            optionIndex = (optionIndex + 1) % 4;
            if (option == '*' || option == '/') {
                int top = numStack.pollLast();
                top = option == '*' ? top * i : top / i;
                numStack.add(top);
            } else {
                numStack.add(i);
                optionStack.add(option);
            }
        }
        while (!optionStack.isEmpty()) {
            char option = optionStack.pollFirst();
            int n1 = numStack.pollFirst();
            int n2 = numStack.pollFirst();
            int res = option == '+' ? n1 + n2 : n1 - n2;
            numStack.addFirst(res);
        }
        return numStack.pollLast();
    }
}
