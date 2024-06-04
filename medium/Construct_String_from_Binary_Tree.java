package medium;

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


    // 二刷
    public String tree2str_2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        return sb.toString();
    }

    public void preOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            return;
        }

        sb.append("(");
        preOrderTraversal(node.left, sb);
        sb.append(")");

        if (node.right != null) {
            sb.append("(");
            preOrderTraversal(node.right, sb);
            sb.append(")");
        }
    }
}
