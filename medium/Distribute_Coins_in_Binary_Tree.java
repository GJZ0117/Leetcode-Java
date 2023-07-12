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
}
