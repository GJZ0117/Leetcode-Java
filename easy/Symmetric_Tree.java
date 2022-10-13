package easy;

/**
 * 101. Symmetric Tree
 */

public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            }
            return check(p.left, q.right) && check(p.right, q.left);
        }
    }
}
