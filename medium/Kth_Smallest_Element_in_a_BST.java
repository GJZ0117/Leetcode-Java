package medium;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 */

public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int times = 0;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                times++;
                if (k == times) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }
}
