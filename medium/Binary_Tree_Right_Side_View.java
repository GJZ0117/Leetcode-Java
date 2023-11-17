package medium;

import java.util.*;

/**
 * 199. Binary Tree Right Side View
 */

public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // level traverse tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    list.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return list;
    }


    // 二刷
    public List<Integer> rightSideView_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode p;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                p = deque.removeFirst();
                if (i == 0) {
                    res.add(p.val);
                }
                if (p.right != null) {
                    deque.add(p.right);
                }
                if (p.left != null) {
                    deque.add(p.left);
                }
            }
        }
        return res;
    }
}
