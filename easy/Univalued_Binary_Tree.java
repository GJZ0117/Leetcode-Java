package easy;

/**
 * 965. Univalued Binary Tree
 */

public class Univalued_Binary_Tree {

    int val = -1;

    public boolean isUnivalTree(TreeNode node) {
        if (node != null) {
            if (val == -1) {
                val = node.val;
            } else if (node.val != val) {
                return false;
            }

            boolean left = isUnivalTree(node.left);
            if (!left) {
                return false;
            }
            boolean right = isUnivalTree(node.right);
            if (!right) {
                return false;
            }
            return true;
        }
        return true;
    }


    // 二刷
    int value = 0;
    boolean flag = true;

    public boolean isUnivalTree_2(TreeNode root) {
        if (root != null) {
            value = root.val;
            preOrder(root);
            return flag;
        } else {
            return true;
        }
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val != value) {
            flag = false;
            return;
        }
        if (flag) {
            preOrder(node.left);
        }
        if (flag) {
            preOrder(node.right);
        }
    }
}
