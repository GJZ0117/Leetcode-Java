package easy;

/**
 * 110. Balanced Binary Tree
 */

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean[] isBalanced = {true};
        height(root, isBalanced);
        return isBalanced[0];
    }

    public static int height(TreeNode root, boolean[] isBalanced) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left, isBalanced);
        int rightHeight = height(root.right, isBalanced);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
