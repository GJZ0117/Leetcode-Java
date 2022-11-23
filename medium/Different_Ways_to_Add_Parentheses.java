package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 */

public class Different_Ways_to_Add_Parentheses {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return dfs(chars, 0, chars.length - 1);
    }

    public static List<Integer> dfs(char[] chars, int left, int right) {
        List<Integer> ans = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            }
            List<Integer> list1 = dfs(chars, left, i - 1);
            List<Integer> list2 = dfs(chars, i + 1, right);
            for (int num1 : list1) {
                for (int num2 : list2) {
                    int cur = cal(num1, num2, chars[i]);
                    ans.add(cur);
                }
            }
        }
        if (ans.isEmpty()) {
            int cur = 0;
            for (int i = left; i <= right; i++) {
                cur = cur * 10 + (chars[i] - '0');
            }
            ans.add(cur);
        }
        return ans;
    }

    public static int cal(int n1, int n2, char op) {
        if (op == '+') {
            return n1 + n2;
        } else if (op == '-') {
            return n1 - n2;
        } else {
            return n1 * n2;
        }
    }
}
