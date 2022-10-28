package easy;

/**
 * 226. Invert Binary Tree
 */

public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                invertTree(root.left);
            }
            if (root.right != null) {
                invertTree(root.right);
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
