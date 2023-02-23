package medium;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. Maximum Width of Binary Tree
 */

public class Maximum_Width_of_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int maxWidth = 0;
        root.val = 1;
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            int startIndex = -1;
            int endIndex = -1;
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.pop();
                endIndex = node.val;
                if (startIndex == -1) {
                    startIndex = node.val;
                }
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    deque.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    deque.add(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, endIndex - startIndex + 1);
        }
        return maxWidth;
    }
}
