package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row
 */

public class Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode p;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxValue = Integer.MIN_VALUE;
            while (len > 0) {
                p = queue.poll();
                maxValue = Math.max(maxValue, p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
                len--;
            }
            list.add(maxValue);
        }
        return list;
    }
}
