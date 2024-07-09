package medium;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 */

public class Binary_Search_Tree_to_Greater_Sum_Tree {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.right);
            node.val = node.val + sum;
            sum += node.val - sum;
            inOrder(node.left);
        }
    }


    // 二刷
    public TreeNode bstToGst_2(TreeNode root) {
        inOrderTraversal(root);
        return root;
    }

    int curSum = 0;

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.right);
        curSum += node.val;
        node.val = curSum;
        inOrderTraversal(node.left);
    }
}
