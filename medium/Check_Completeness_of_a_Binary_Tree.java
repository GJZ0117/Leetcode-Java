package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 958. Check Completeness of a Binary Tree
 */

public class Check_Completeness_of_a_Binary_Tree {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int len;
        TreeNode p;
        boolean findFirstNull = false;
        while (!queue.isEmpty()) {
            len = queue.size();
            while (len > 0) {
                p = queue.pollFirst();

                if (p.left == null) {
                    findFirstNull = true;
                } else if (!findFirstNull && p.left != null) {
                    queue.add(p.left);
                } else {
                    return false;
                }

                if (p.right == null) {
                    findFirstNull = true;
                } else if (!findFirstNull && p.right != null) {
                    queue.add(p.right);
                } else {
                    return false;
                }

                len--;
            }
        }
        return true;
    }
}
