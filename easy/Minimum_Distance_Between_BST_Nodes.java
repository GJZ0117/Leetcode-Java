package easy;

/**
 * 783. Minimum Distance Between BST Nodes
 */

public class Minimum_Distance_Between_BST_Nodes {

    Integer minDiff = Integer.MAX_VALUE;
    Integer pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);
            if (pre != null) {
                minDiff = Math.min(minDiff, root.val - pre);
            }
            pre = root.val;
            minDiffInBST(root.right);
        }
        return minDiff;
    }
}
