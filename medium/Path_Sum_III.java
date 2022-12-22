package medium;

/**
 * 437. Path Sum III
 */

public class Path_Sum_III {
    public int pathSum(TreeNode root, int targetSum) {
        int[] path = {0};

        if (root != null) {
            preOrder(root, targetSum, 0, path);
            path[0] += pathSum(root.left, targetSum);
            path[0] += pathSum(root.right, targetSum);
        }

        return path[0];
    }

    public void preOrder(TreeNode cur, int targetSum, long curSum, int[] path) {
        if (cur != null) {
            long sum = curSum + cur.val;
            if (sum == (long) targetSum) {
                path[0]++;
            }
            preOrder(cur.left, targetSum, sum, path);
            preOrder(cur.right, targetSum, sum, path);
        }
    }
}
