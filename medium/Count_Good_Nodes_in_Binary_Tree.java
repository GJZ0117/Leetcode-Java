package medium;

/**
 * 1448. Count Good Nodes in Binary Tree
 */

public class Count_Good_Nodes_in_Binary_Tree {
    public int goodNodes(TreeNode root) {
        preOrder(root, Integer.MIN_VALUE);
        return ans;
    }

    int ans = 0;

    public void preOrder(TreeNode node, int maxPrev) {
        if (node == null) {
            return;
        }
        if (node.val >= maxPrev) {
            ans++;
        }
        preOrder(node.left, Math.max(maxPrev, node.val));
        preOrder(node.right, Math.max(maxPrev, node.val));
    }
}
