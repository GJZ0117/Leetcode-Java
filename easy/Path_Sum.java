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


    // 二刷
    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        preOrder(root, targetSum, 0);
        return flag;
    }

    boolean flag = false;

    public void preOrder(TreeNode node, int targetSum, int curSum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && curSum + node.val == targetSum) {
            flag = true;
        }
        preOrder(node.left, targetSum, curSum + node.val);
        preOrder(node.right, targetSum, curSum + node.val);
    }
}
