package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 385. Mini Parser
 */

public class Mini_Parser {

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);

            if (cur == '[') {
                stack.add(new NestedInteger());
            } else if (cur == '-' || (cur >= '0' && cur <= '9')) {
                int num = cur == '-' ? 0 : cur - '0';
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                i = j - 1;
                num = cur == '-' ? -num : num;
                stack.peek().add(new NestedInteger(num));
            } else if (cur == ']') {
                if (stack.size() > 1) {
                    NestedInteger top = stack.pop();
                    stack.peek().add(top);
                }
            }
        }
        return stack.peek();
    }

    class NestedInteger {
        Integer v;
        List<NestedInteger> l;
        boolean single;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            single = false;
            l = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            single = true;
            v = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return single;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return single ? v : null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            if (single) {
                v = value;
            }
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            if (!single) {
                l.add(ni);
            }
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return single ? null : l;
        }
    }
}


