package easy;

/**
 * 700. Search in a Binary Search Tree
 */

public class Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }


    // 二刷
    public TreeNode searchBST_2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST_2(root.left, val);
        } else {
            return searchBST_2(root.right, val);
        }
    }
}