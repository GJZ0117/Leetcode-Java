package easy;

/**
 * 563. Binary Tree Tilt
 */

public class Binary_Tree_Tilt {
    public int findTilt(TreeNode root) {
        int[] tilt = {0};
        postOrder(root, tilt);
        return tilt[0];
    }

    public int postOrder(TreeNode cur, int[] tilt) {
        if (cur == null) {
            return 0;
        }
        int left = postOrder(cur.left, tilt);
        int right = postOrder(cur.right, tilt);
        tilt[0] += Math.abs(left - right);
        return left + right + cur.val;
    }
}
