package medium;

/**
 * 99. Recover Binary Search Tree
 */

public class Recover_Binary_Search_Tree {
    TreeNode pre;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null && root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        inOrder(root.right);
    }
}
