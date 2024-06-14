package medium;

import java.util.ArrayDeque;
import java.util.Deque;

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


    // 二刷
    public TreeNode addOneRow_2(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.removeFirst();
                if (curDepth == depth - 1) {
                    TreeNode newNode1 = new TreeNode(val);
                    TreeNode newNode2 = new TreeNode(val);
                    newNode1.left = node.left;
                    node.left = newNode1;
                    newNode2.right = node.right;
                    node.right = newNode2;
                } else {
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
                len--;
            }
            curDepth++;
        }
        return root;
    }
}
