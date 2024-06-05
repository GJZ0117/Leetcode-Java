package easy;

/**
 * 617. Merge Two Binary Trees
 */

public class Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        if (root1.left != null && root2.left != null) {
            mergeTrees(root1.left, root2.left);
        } else if (root1.left == null) {
            root1.left = root2.left;
        }

        if (root1.right != null && root2.right != null) {
            mergeTrees(root1.right, root2.right);
        } else if (root1.right == null) {
            root1.right = root2.right;
        }

        return root1;
    }


    // 二刷
    public TreeNode mergeTrees_2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        if (root1.left != null && root2.left != null) {
            mergeTrees_2(root1.left, root2.left);
        } else if (root1.left == null) {
            root1.left = root2.left;
        }

        if (root1.right != null && root2.right != null) {
            mergeTrees_2(root1.right, root2.right);
        } else if (root1.right == null) {
            root1.right = root2.right;
        }

        return root1;
    }
}
