package hard;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 124. Binary Tree Maximum Path Sum
 */

public class Binary_Tree_Maximum_Path_Sum {

    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        postOrder(root, maxSum);
        return maxSum[0];
    }

    public static int postOrder(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        int left = Math.max(0, postOrder(root.left, maxSum)); //find the largest path in left child tree
        int right = Math.max(0, postOrder(root.right, maxSum)); //find the largest path in right child tree
        maxSum[0] = Math.max(maxSum[0], left + right + root.val); //largest path equals the largest of current path and (left child tree + right child tree + root.val)
        return Math.max(left, right) + root.val; //current root's longest path
    }
}
