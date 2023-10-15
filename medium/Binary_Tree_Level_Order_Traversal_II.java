package medium;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 */

public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int len;
        TreeNode p;
        queue.add(root);
        while (!queue.isEmpty()) {
            len = queue.size();
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
        }
        List<List<Integer>> reverseAns = new ArrayList<>();
        for (int i = ans.size() - 1; i >= 0; i--) {
            reverseAns.add(ans.get(i));
        }
        return reverseAns;
    }


    // 二刷
    public List<List<Integer>> levelOrderBottom_2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int len;
        TreeNode p;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            len = deque.size();
            while (len > 0) {
                p = deque.removeFirst();
                list.add(p.val);
                if (p.left != null) {
                    deque.addLast(p.left);
                }
                if (p.right != null) {
                    deque.addLast(p.right);
                }
                len--;
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        Collections.reverse(res);
        return res;
    }
}
