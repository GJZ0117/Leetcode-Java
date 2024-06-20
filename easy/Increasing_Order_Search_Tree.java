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
            } else {
                pre.right = node;
                node.left = null;
                pre = node;
            }
            inOrder(node.right);
        }
    }


    // 二刷
    public TreeNode increasingBST_2(TreeNode root) {
        inOrderTraversal(root);
        return newRoot;
    }

    TreeNode newRoot = null;
    TreeNode preNode = null;

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (newRoot == null) {
            newRoot = node;
            preNode = node;
        } else {
            node.left = null;
            preNode.right = node;
            preNode = node;
        }
        inOrderTraversal(node.right);
    }
}
