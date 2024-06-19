package medium;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 */

public class Smallest_Subtree_with_all_the_Deepest_Nodes {
    int maxDepth = Integer.MIN_VALUE;
    TreeNode result = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        postOrder(root, 0);
        return result;
    }

    public int postOrder(TreeNode node, int deep) {
        if (node == null) {
            return deep;
        }
        int left = postOrder(node.left, deep + 1);
        int right = postOrder(node.right, deep + 1);
        int curDepth = Math.max(left, right);
        maxDepth = Math.max(maxDepth, curDepth);
        if (left == maxDepth && right == maxDepth) {
            result = node;
        }
        return curDepth;
    }


    // 二刷
    public TreeNode subtreeWithAllDeepest_2(TreeNode root) {
        if (root == null) {
            return root;
        }
        int leftMaxDepth = getMaxDepth(root.left);
        int rightMaxDepth = getMaxDepth(root.right);

        if (leftMaxDepth == rightMaxDepth) {
            return root;
        } else if (leftMaxDepth > rightMaxDepth) {
            return subtreeWithAllDeepest_2(root.left);
        } else {
            return subtreeWithAllDeepest_2(root.right);
        }

    }

    public int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }
}
