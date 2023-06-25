package easy;

/**
 * 993. Cousins in Binary Tree
 */

public class Cousins_in_Binary_Tree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }

        int[] xParentVal = new int[1];
        int[] yParentVal = new int[1];
        int[] xDepth = new int[1];
        int[] yDepth = new int[1];

        inOrder(root, x, xParentVal, xDepth);
        inOrder(root, y, yParentVal, yDepth);
        return (xDepth[0] == yDepth[0]) && (xParentVal[0] != yParentVal[0]);
    }

    public void inOrder(TreeNode root, int target, int[] parentVal, int[] depth) {
        if (root != null) {
            if (root.left != null && root.left.val == target || root.right != null && root.right.val == target) {
                parentVal[0] = root.val;
                depth[0]++;
                return;
            }
            depth[0]++;
            inOrder(root.left, target, parentVal, depth);
            if (parentVal[0] != 0) {
                return;
            }
            inOrder(root.right, target, parentVal, depth);
            if (parentVal[0] != 0) {
                return;
            }
            depth[0]--;
        }
    }
}
