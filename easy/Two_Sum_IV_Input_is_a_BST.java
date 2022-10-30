package easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 653. Two Sum IV - Input is a BST
 */

public class Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        if (root != null) {
            Set<Integer> set = new HashSet<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p;
            stack.push(root);
            while (!stack.isEmpty()) {
                p = stack.pop();
                if (set.contains(k - p.val)) {
                    return true;
                }
                set.add(p.val);
                if (p.right != null) {
                    stack.add(p.right);
                }
                if (p.left != null) {
                    stack.add(p.left);
                }
            }
        }
        return false;
    }
}
