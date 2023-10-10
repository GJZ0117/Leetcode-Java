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

    // 二刷（还不会）
    TreeNode prevNode = null;
    TreeNode firstNode = null;
    TreeNode secondNode = null;

    public void recoverTree_2(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTravel(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.left);
        if (prevNode != null && node.val < prevNode.val) {
            if (firstNode == null) {
                firstNode = prevNode;
            }
            secondNode = node;
        }
        prevNode = node;
        inOrderTravel(node.right);
    }
}
