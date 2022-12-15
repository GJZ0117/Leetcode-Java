package easy;

/**
 * 572. Subtree of Another Tree
 */

public class Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root != null) {
            if (root.val == subRoot.val) {
                boolean temp = compare(root, subRoot);
                if (temp) {
                    return true;
                }
            }
            boolean left = isSubtree(root.left, subRoot);
            if (left) {
                return true;
            }
            boolean right = isSubtree(root.right, subRoot);
            if (right) {
                return true;
            }
        }
        return false;
    }

    public boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return compare(p.left, q.left) && compare(p.right, q.right);
        }
    }
}
