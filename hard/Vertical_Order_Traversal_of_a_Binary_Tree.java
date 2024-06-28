package hard;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 */

public class Vertical_Order_Traversal_of_a_Binary_Tree {
    // https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/solutions/2638913/si-chong-xie-fa-dfsha-xi-biao-shuang-shu-tg6q/?show=1
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> groups = new TreeMap<>();
        dfs(root, 0, 0, groups);

        List<List<Integer>> list = new ArrayList<>();
        System.out.println(groups);
        for (List<int[]> group : groups.values()) {
            group.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> vals = new ArrayList<>();
            for (int[] g : group) {
                vals.add(g[1]);
            }
            list.add(vals);
        }
        return list;
    }

    public void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> groups) {
        if (node == null) {
            return;
        }
        groups.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, groups);
        dfs(node.right, row + 1, col + 1, groups);
    }
}
