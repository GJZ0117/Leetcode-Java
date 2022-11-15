package medium;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */

public class Binary_Search_Tree_Iterator {
    Stack<TreeNode> stack = new Stack<>();

    public Binary_Search_Tree_Iterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topNode = stack.pop();
        TreeNode newRoot = topNode.right;
        while (newRoot != null) {
            stack.push(newRoot);
            newRoot = newRoot.left;
        }
        return topNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
