package medium;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 */

public class Sum_of_Nodes_with_EvenValued_Grandparent {
    public int sumEvenGrandparent(TreeNode root) {
        preOrder(root);
        return sum;
    }

    int sum = 0;

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    sum += node.left.left.val;
                }
                if (node.left.right != null) {
                    sum += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    sum += node.right.left.val;
                }
                if (node.right.right != null) {
                    sum += node.right.right.val;
                }
            }
        }

        preOrder(node.left);
        preOrder(node.right);
    }
}
