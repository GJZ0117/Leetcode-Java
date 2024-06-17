package easy;

import java.util.HashSet;
import java.util.Set;

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


    // 二刷
    public int findSecondMinimumValue_2(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        preOrder(root, set);
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        if (set.size() < 2) {
            return -1;
        } else {
            for (int val : set) {
                if (firstMin > val) {
                    secondMin = firstMin;
                    firstMin = val;
                } else if (secondMin > val) {
                    secondMin = val;
                }
            }
        }
        return secondMin;
    }

    public void preOrder(TreeNode node, Set<Integer> set) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        preOrder(node.left, set);
        preOrder(node.right, set);
    }
}
