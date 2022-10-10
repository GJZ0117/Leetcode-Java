package medium;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 */

public class Validate_Binary_Search_Tree {
    //非递归中序遍历的思路，用一个栈遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null; //保存中序遍历过程中某个节点的前一个节点
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre!=null && root.val <= pre.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
