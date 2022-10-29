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
                }else if (cur.val > val) {
                    cur = cur.left;
                }else {
                    break;
                }
            }
            TreeNode node = new TreeNode(val);
            if (pre.val > val) {
                pre.left = node;
            }else if (pre.val < val){
                pre.right = node;
            }
        }else {
            root = new TreeNode(val);
        }
        return root;
    }
}
