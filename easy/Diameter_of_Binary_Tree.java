package easy;

/**
 * 543. Diameter of Binary Tree
 */

public class Diameter_of_Binary_Tree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {0};
        postOrder(root, diameter);
        return diameter[0];
    }

    public int postOrder(TreeNode cur, int[] diameter) {
        if (cur == null) {
            return -1;
        }
        int left = postOrder(cur.left, diameter) + 1;
        int right = postOrder(cur.right, diameter) + 1;
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right);
    }


    // 二刷
    public int diameterOfBinaryTree_2(TreeNode root) {
        post(root);
        return ans;
    }

    int ans = 0;

    public int post(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = post(node.left) + 1;
        int right = post(node.right) + 1;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
