package medium;

/**
 * 669. Trim a Binary Search Tree
 */

public class Trim_a_Binary_Search_Tree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


    // 二刷
    public TreeNode trimBST_2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST_2(root.right, low, high);
        } else if (root.val > high) {
            return trimBST_2(root.left, low, high);
        }

        root.left = trimBST_2(root.left, low, high);
        root.right = trimBST_2(root.right, low, high);
        return root;
    }
}
