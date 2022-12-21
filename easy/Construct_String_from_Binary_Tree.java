package easy;

/**
 * 606. Construct String from Binary Tree
 */

public class Construct_String_from_Binary_Tree {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode cur, StringBuilder sb) {
        if (cur != null) {
            sb.append(cur.val);
            boolean hasChild = false;
            if (cur.left != null || cur.right != null) {
                hasChild = true;
            }
            if (hasChild) {
                sb.append("(");
                preOrder(cur.left, sb);
                sb.append(")");
            }
            if (cur.right != null) {
                sb.append("(");
                preOrder(cur.right, sb);
                sb.append(")");
            }
        }
    }
}
