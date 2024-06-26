package medium;

/**
 * 979. Distribute Coins in Binary Tree
 */

public class Distribute_Coins_in_Binary_Tree {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return res;
    }

    public int postOrder(TreeNode node) {
        if (node != null) {
            int left = postOrder(node.left);
            res += Math.abs(left);
            int right = postOrder(node.right);
            res += Math.abs(right);
            return left + right + node.val - 1;
        } else {
            return 0;
        }
    }


    // 二刷
    // https://leetcode.cn/problems/distribute-coins-in-binary-tree/solutions/265089/hou-xu-bian-li-cong-dang-qian-jie-dian-na-chu-node/?show=1
    public int distributeCoins_2(TreeNode root) {
        if (dfs(root) == 0) {
            return ans;
        }
        return -1;
    }

    int ans = 0;

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        ans += Math.abs(left);
        int right = dfs(node.right);
        ans += Math.abs(right);
        return left + right + node.val - 1;
    }
}
