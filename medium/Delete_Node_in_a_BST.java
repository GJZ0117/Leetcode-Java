package medium;

/**
 * 450. Delete Node in a BST
 */

public class Delete_Node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode leftTreeMaxNode = root.left;
            while (leftTreeMaxNode.right != null) {
                leftTreeMaxNode = leftTreeMaxNode.right;
            }
            leftTreeMaxNode.right = root.right;
            return root.left;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }


    // 二刷
    public TreeNode deleteNode_2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode rightTreeMinNode = root.right;
            while (rightTreeMinNode.left != null) {
                rightTreeMinNode = rightTreeMinNode.left;
            }
            root.right = deleteNode_2(root.right, rightTreeMinNode.val);
            rightTreeMinNode.left = root.left;
            rightTreeMinNode.right = root.right;
            return rightTreeMinNode;
        } else if (root.val > key) {
            root.left = deleteNode_2(root.left, key);
        } else {
            root.right = deleteNode_2(root.right, key);
        }
        return root;
    }
}
