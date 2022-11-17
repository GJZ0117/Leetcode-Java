package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 */

public class Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null && (node.left.left == null && node.left.right == null)) {
                ans += node.left.val;
            } else if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);

            }
        }
        return ans;
    }
}
