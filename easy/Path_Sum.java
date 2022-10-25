package easy;

/**
 * 112. Path Sum
 */

public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            targetSum -= root.val;
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum - root.val);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum - root.val);
            if (right) {
                return true;
            }
        }
        return false;
    }
}
