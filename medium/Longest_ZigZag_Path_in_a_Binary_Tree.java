package medium;

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 */

public class Longest_ZigZag_Path_in_a_Binary_Tree {
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, true, 0), dfs(root.right, false, 0));
    }

    public int dfs(TreeNode node, boolean prevLeft, int len) {
        if (node == null) {
            return len;
        }
        if (prevLeft) {
            return Math.max(dfs(node.right, false, len + 1), dfs(node.left, prevLeft, 0));
        } else {
            return Math.max(dfs(node.left, true, len + 1), dfs(node.right, false, 0));
        }
    }
}
