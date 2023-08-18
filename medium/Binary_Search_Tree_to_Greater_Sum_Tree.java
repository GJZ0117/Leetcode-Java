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
}
