package easy;

/**
 * 938. Range Sum of BST
 */

public class Range_Sum_of_BST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    // 二刷
    public int rangeSumBST_2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST_2(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST_2(root.left, low, high);
        }
        return root.val + rangeSumBST_2(root.left, low, high) + rangeSumBST_2(root.right, low, high);

    }
}
