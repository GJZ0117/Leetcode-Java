package easy;

/**
 * 530. Minimum Absolute Difference in BST
 */

public class Minimum_Absolute_Difference_in_BST {
    public int getMinimumDifference(TreeNode root) {
        int[] preValue = {-1};
        int[] minDiff = {Integer.MAX_VALUE};
        inOrder(root, preValue, minDiff);
        return minDiff[0];
    }

    public void inOrder(TreeNode cur, int[] preValue, int[] minDiff) {
        if (cur != null) {
            inOrder(cur.left, preValue, minDiff);
            int curDiff = cur.val - preValue[0];
            if (preValue[0] != -1) {
                minDiff[0] = Math.min(minDiff[0], curDiff);
            }
            preValue[0] = cur.val;
            inOrder(cur.right, preValue, minDiff);
        }
    }


    // 二刷
    public int getMinimumDifference_2(TreeNode root) {
        inOrderTraversal(root);
        return ans;
    }

    int ans = Integer.MAX_VALUE;
    Integer pre = null;

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);

        if (pre == null) {
            pre = node.val;
        } else {
            ans = Math.min(ans, Math.abs(pre - node.val));
            pre = node.val;
        }

        inOrderTraversal(node.right);
    }
}
