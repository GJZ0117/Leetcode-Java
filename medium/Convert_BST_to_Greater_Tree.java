package medium;

/**
 * 538. Convert BST to Greater Tree
 */

public class Convert_BST_to_Greater_Tree {

    private int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        rightToLeft(root);
        return root;
    }

    public void rightToLeft(TreeNode node) {
        if (node != null) {
            rightToLeft(node.right);
            int curVal = node.val;
            node.val += preSum;
            preSum += curVal;
            rightToLeft(node.left);
        }
    }


    // 二刷
    public TreeNode convertBST_2(TreeNode root) {
        inOrder(root);
        return root;
    }

    int preTotal = 0;

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        int cur = node.val;
        node.val += preTotal;
        preTotal += cur;
        inOrder(node.left);
    }
}
