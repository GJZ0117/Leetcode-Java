package easy;

/**
 * 671. Second Minimum Node In a Binary Tree
 */

public class Second_Minimum_Node_In_a_Binary_Tree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return -1;
        }

        int leftChildVal = root.left.val;
        int rightChildVal = root.right.val;
        if (root.val == root.left.val) {
            leftChildVal = findSecondMinimumValue(root.left);
        }
        if (root.val == root.right.val) {
            rightChildVal = findSecondMinimumValue(root.right);
        }

        if (leftChildVal == -1) {
            return rightChildVal;
        }
        if (rightChildVal == -1) {
            return leftChildVal;
        }
        return Math.min(leftChildVal, rightChildVal);
    }
}
