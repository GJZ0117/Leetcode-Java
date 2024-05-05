package medium;

/**
 * 1325. Delete Leaves With a Given Value
 */

public class Delete_Leaves_With_a_Given_Value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean flag = postOrder(root, target);
        return flag ? null : root;
    }

    public boolean postOrder(TreeNode node, int target) {
        if (node == null) {
            return false;
        }

        if (postOrder(node.left, target)) {
            node.left = null;
        }

        if (postOrder(node.right, target)) {
            node.right = null;
        }

        if (node.left == null && node.right == null && node.val == target) {
            return true;
        } else {
            return false;
        }
    }
}
