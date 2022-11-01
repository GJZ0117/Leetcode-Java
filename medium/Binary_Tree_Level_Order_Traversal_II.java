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
}
