package medium;

import java.util.*;

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


    // 二刷
    public List<Integer> largestValues_2(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.addLast(root);
        TreeNode p;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxVal = Integer.MIN_VALUE;
            while (len > 0) {
                p = queue.pollFirst();
                if (p.val > maxVal) {
                    maxVal = p.val;
                }
                if (p.left != null) {
                    queue.addLast(p.left);
                }
                if (p.right != null) {
                    queue.addLast(p.right);
                }
                len--;
            }
            list.add(maxVal);
        }
        return list;
    }
}
