package easy;

/**
 * 104. Maximum Depth of Binary Tree
 */

public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }


    // 二刷
    public int maxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth_2(root.left) + 1;
        int right = maxDepth_2(root.right) + 1;
        return Math.max(left, right);
    }
}
