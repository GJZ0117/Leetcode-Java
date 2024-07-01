package medium;

/**
 * 998. Maximum Binary Tree II
 */

public class Maximum_Binary_Tree_II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return dfs(root, val);
    }

    public TreeNode dfs(TreeNode node, int val) {
        if (node == null || node.val < val) {
            return new TreeNode(val, node, null);
        }
        node.right = dfs(node.right, val);
        return node;
    }


    // 二刷
    public TreeNode insertIntoMaxTree_2(TreeNode root, int val) {
        return insert(root, val);
    }

    public TreeNode insert(TreeNode node, int val) {
        if (node == null || node.val < val) {
            return new TreeNode(val, node, null);
        }
        node.right = insert(node.right, val);
        return node;
    }
}
