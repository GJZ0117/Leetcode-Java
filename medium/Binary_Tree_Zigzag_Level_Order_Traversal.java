package medium;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len;
        TreeNode p;
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            len = queue.size();
            if (leftToRight) {
                while (len > 0) {
                    p = queue.poll();
                    list.add(p.val);
                    if (p.left != null) {
                        queue.add(p.left);
                    }
                    if (p.right != null) {
                        queue.add(p.right);
                    }
                    len--;
                }
                ans.add(new ArrayList<>(list));
                list.clear();
                leftToRight = false;
            } else {
                while (len > 0) {
                    p = queue.poll();
                    list.add(p.val);
                    if (p.left != null) {
                        queue.add(p.left);
                    }
                    if (p.right != null) {
                        queue.add(p.right);
                    }
                    len--;
                }
                Collections.reverse(list);
                ans.add(new ArrayList<>(list));
                list.clear();
                leftToRight = true;
            }
        }
        return ans;
    }
}
