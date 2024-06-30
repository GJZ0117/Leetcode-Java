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


    // 二刷
    public boolean isCousins_2(TreeNode root, int x, int y) {
        preOrder(root, 0, x, y);
        return depth[0] == depth[1] && !(root.left != null && root.right != null && ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)));
    }

    int[] depth = new int[2];
    int depthIndex = 0;
    TreeNode parent;

    public void preOrder(TreeNode node, int curDepth, int x, int y) {
        if (node == null) {
            return;
        }
        if (node.left != null && (node.left.val == x || node.left.val == y)) {
            depth[depthIndex++] = curDepth + 1;
            parent = node;
        } else if (node.right != null && (node.right.val == x || node.right.val == y)) {
            depth[depthIndex++] = curDepth + 1;
            parent = node;
        }
        preOrder(node.left, curDepth + 1, x, y);
        preOrder(node.right, curDepth + 1, x, y);
    }
}
