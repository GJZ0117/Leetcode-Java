package medium;

/**
 * 623. Add One Row to Tree
 */

public class Add_One_Row_to_Tree {
    TreeNode pre = null;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (pre == null && depth == 1) {
            TreeNode node = new TreeNode();
            node.val = val;
            node.left = root;
            return node;
        }
        if (root != null) {
            pre = root;
            if (depth == 2) {
                TreeNode leftNode = new TreeNode();
                leftNode.val = val;
                leftNode.left = root.left;
                root.left = leftNode;
                TreeNode rightNode = new TreeNode();
                rightNode.val = val;
                rightNode.right = root.right;
                root.right = rightNode;
            } else {
                addOneRow(root.left, val, depth - 1);
                addOneRow(root.right, val, depth - 1);
            }
        }
        return root;
    }
}
