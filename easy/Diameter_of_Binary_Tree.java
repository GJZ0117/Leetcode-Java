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
}
