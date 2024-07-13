package medium;

/**
 * 701. Insert into a Binary Search Tree
 */

public class Insert_into_a_Binary_Search_Tree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null) {
            TreeNode pre = null;
            TreeNode cur = root;
            while (cur != null) {
                pre = cur;
                if (cur.val < val) {
                    cur = cur.right;
                } else if (cur.val > val) {
                    cur = cur.left;
                } else {
                    break;
                }
            }
            TreeNode node = new TreeNode(val);
            if (pre.val > val) {
                pre.left = node;
            } else if (pre.val < val) {
                pre.right = node;
            }
        } else {
            root = new TreeNode(val);
        }
        return root;
    }


    // 二刷
    public TreeNode insertIntoBST_2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}
