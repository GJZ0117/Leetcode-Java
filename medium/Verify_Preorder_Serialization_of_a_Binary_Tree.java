package medium;

import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 */

public class Verify_Preorder_Serialization_of_a_Binary_Tree {
    // https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solution/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/

    // put every node include null into stack, when there are two continuous null push into stack, then pop them and the precious node. Add one null into stack. (pop leaf nodes and push a null)
    public boolean isValidSerialization1(String preorder) {
        Stack<String> stack = new Stack<>();
        for (String str : preorder.split(",")) {
            stack.push(str);
            while (stack.size() >= 3 && stack.get(stack.size() - 1).equals("#") && stack.get(stack.size() - 2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return (stack.size() == 1 && stack.peek().equals("#"));
    }

    // if a node is not null, it has one in-degree and two out-dgree (root node has 0 in-degree)
    public boolean isValidSerialization2(String preorder) {
        int diff = 1; // eliminate root node's in-degree
        for (String str : preorder.split(",")) {
            diff -= 1;
            if (diff < 0) {
                return false;
            }
            if (!str.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }


    // 二刷(还不会)
    // 用前序遍历当遇到 x,#,# 时把它们变成#
    // 题目中出现了新样例 "1,#,#,#,#",最上面的方法无法通过，需加一条父节点是否为#的判断
    public boolean isValidSerialization_2(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            stack.push(node);
            while (stack.size() >= 3 && "#".equals(stack.get(stack.size() - 1)) && "#".equals(stack.get(stack.size() - 2)) && !"#".equals(stack.get(stack.size() - 3))) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return (stack.size() == 1 && "#".equals(stack.peek()));
    }
}