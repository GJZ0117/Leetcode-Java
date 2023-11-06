package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 155. Min Stack
 */

public class Min_Stack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(Integer.MAX_VALUE);
            minStack.push(val);
        } else if (minStack.peek() < val) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class MinStack {

    Deque<Integer> deque = new ArrayDeque<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MinStack() {
    }

    public void push(int val) {
        deque.addLast(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        int key = deque.removeLast();
        if (map.get(key).equals(1)) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    public int top() {
        return deque.peekLast();
    }

    public int getMin() {
        return map.firstKey();
    }
}

