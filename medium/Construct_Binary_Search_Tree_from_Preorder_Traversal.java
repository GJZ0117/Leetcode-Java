package medium;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 */

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        for (int i = 1; i < preorder.length; i++) {
            addTreeNode(root, preorder[i]);
        }
        return root;
    }

    public TreeNode addTreeNode(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        } else if (node.val > val) {
            node.left = addTreeNode(node.left, val);
        } else {
            node.right = addTreeNode(node.right, val);
        }
        return node;
    }


    // 二刷
    public TreeNode bstFromPreorder_2(int[] preorder) {
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        for (int i = 1; i < preorder.length; i++) {
            buildTree(root, preorder[i]);
        }
        return root;
    }

    public void buildTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode p = root;
        while (true) {
            if (p.val > val) {
                if (p.left == null) {
                    p.left = node;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = node;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
    }
}
