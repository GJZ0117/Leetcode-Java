package medium;

/**
 * 951. Flip Equivalent Binary Trees
 */

public class Flip_Equivalent_Binary_Trees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) {
                return false;
            }
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        } else if (root1 == null && root2 == null) {
            return true;
        } else {
            return false;
        }
    }


    // 二刷
    public boolean flipEquiv_2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else {
            if (root1.val == root2.val) {
                return (flipEquiv_2(root1.left, root2.left) && flipEquiv_2(root1.right, root2.right))
                        || (flipEquiv_2(root1.left, root2.right) && flipEquiv_2(root1.right, root2.left));
            } else {
                return false;
            }
        }
    }
}
