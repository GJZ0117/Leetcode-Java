package medium;

/**
 * 1026. Maximum Difference Between Node and Ancestor
 */

public class Maximum_Difference_Between_Node_and_Ancestor {

    int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        preOrder(root, root.val, root.val);
        return ans;
    }

    private void preOrder(TreeNode node, int min, int max) {
        if (node != null) {
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
            ans = Math.max(ans, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
            preOrder(node.left, min, max);
            preOrder(node.right, min, max);
        }
    }
}
