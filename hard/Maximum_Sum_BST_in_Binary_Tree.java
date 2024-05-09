package hard;

/**
 * 1373. Maximum Sum BST in Binary Tree
 */

public class Maximum_Sum_BST_in_Binary_Tree {

    // https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/?show=1

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int val = node.val;

        if (val <= left[1] || val >= right[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        int sum = left[2] + right[2] + val;
        ans = Math.max(ans, sum);
        return new int[]{Math.min(left[0], val), Math.max(right[1], val), sum};
    }
}
