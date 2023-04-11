package medium;

/**
 * 814. Binary Tree Pruning
 */

public class Binary_Tree_Pruning {
    public TreeNode pruneTree(TreeNode root) {
        boolean flag = postOrder(root);
        if (!flag) {
            return null;
        }
        return root;
    }

    public boolean postOrder(TreeNode root) {
        if (root != null) {
            boolean leftChildren = postOrder(root.left);
            if (!leftChildren) {
                root.left = null;
            }
            boolean rightChildren = postOrder(root.right);
            if (!rightChildren) {
                root.right = null;
            }
            if (!leftChildren && !rightChildren && root.val == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
