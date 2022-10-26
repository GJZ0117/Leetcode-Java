package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 */

public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode p;
            stack1.push(root);
            while (!stack1.isEmpty()) {
                p = stack1.pop();
                stack2.push(p);
                if (p.left != null) {
                    stack1.push(p.left);
                }
                if (p.right != null) {
                    stack1.push(p.right);
                }
            }
            while (!stack2.isEmpty()) {
                p = stack2.pop();
                ans.add(p.val);
            }
        }
        return ans;
    }
}
