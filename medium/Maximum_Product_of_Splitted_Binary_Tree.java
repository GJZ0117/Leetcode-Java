package medium;

/**
 * 1339. Maximum Product of Splitted Binary Tree
 */

public class Maximum_Product_of_Splitted_Binary_Tree {
    double ans = Double.MIN_VALUE;
    double allSum;
    double nodeSum;

    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        dfs(root);
        return (int) (ans % (int) (1e9 + 7));
    }

    public double sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }

    public double dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        nodeSum = root.val + dfs(root.left) + dfs(root.right);
        ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
        return nodeSum;
    }
}
