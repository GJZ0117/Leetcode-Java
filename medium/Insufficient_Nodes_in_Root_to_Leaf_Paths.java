package medium;

/**
 * 1080. Insufficient Nodes in Root to Leaf Paths
 */

public class Insufficient_Nodes_in_Root_to_Leaf_Paths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        return root.left == null && root.right == null ? null : root;
    }
}
