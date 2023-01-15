package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 513. Find Bottom Left Tree Value
 */

public class Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode p;
        TreeNode rowFirst = root;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                len--;
            }
            if (!queue.isEmpty()) {
                rowFirst = queue.peekFirst();
            }
        }
        return rowFirst.val;
    }
}
