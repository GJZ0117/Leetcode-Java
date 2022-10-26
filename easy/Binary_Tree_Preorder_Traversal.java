package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 */

public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p;
            stack.push(root);
            while (!stack.isEmpty()) {
                p = stack.pop();
                ans.add(p.val);
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }
        return ans;
    }
}
