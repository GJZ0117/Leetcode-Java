package easy;

/**
 * 897. Increasing Order Search Tree
 */

public class Increasing_Order_Search_Tree {

    TreeNode pre = null;
    TreeNode resRoot = null;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return resRoot;
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            if (pre == null) {
                resRoot = node;
                pre = node;
            }else {
                pre.right = node;
                node.left = null;
                pre = node;
            }
            inOrder(node.right);
        }
    }
}
