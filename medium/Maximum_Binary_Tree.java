package medium;

/**
 * 654. Maximum Binary Tree
 */

public class Maximum_Binary_Tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = findMaxNumIndex(num, left, right);
        TreeNode node = new TreeNode();
        node.val = num[maxIndex];
        node.left = construct(num, left, maxIndex - 1);
        node.right = construct(num, maxIndex + 1, right);
        return node;
    }

    public int findMaxNumIndex(int[] num, int left, int right) {
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            index = num[i] > num[index] ? i : index;
        }
        return index;
    }
}
