package easy;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return create(nums, 0, nums.length - 1);
    }

    public static TreeNode create(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, low, mid - 1);
        root.right = create(nums, mid + 1, high);
        return root;
    }
}
