package easy;

/**
 * 111. Minimum Depth of Binary Tree
 */

public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left) + 1;
        }
        if (root.right != null) {
            right = minDepth(root.right) + 1;
        }
        return Math.min(left, right);
    }


    // 二刷
    public int minDepth_2(TreeNode root) {
        preOrder(root, 1);
        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }

    int minDepth = Integer.MAX_VALUE;

    public void preOrder(TreeNode node, int curDepth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, curDepth);
        }
        preOrder(node.left, curDepth + 1);
        preOrder(node.right, curDepth + 1);
    }
}
