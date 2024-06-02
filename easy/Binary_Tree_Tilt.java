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


    // 二刷
    public int findTilt_2(TreeNode root) {
        postOrderTraversal(root);
        return ans;
    }

    int ans = 0;

    public int postOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrderTraversal(root.left);
        int right = postOrderTraversal(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }
}
