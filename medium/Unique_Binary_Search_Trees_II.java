package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 */

public class Unique_Binary_Search_Trees_II {
    //dp
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new ArrayList[n + 1];
        result[0] = new ArrayList<>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (TreeNode nodeL : result[i]) {
                    for (TreeNode nodeR : result[len - i - 1]) {
                        TreeNode node = new TreeNode(i + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, i + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    public TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }


    // 二刷（还不会）
    public List<TreeNode> generateTrees_2(int n) {
        return ways(1, n);
    }

    private List<TreeNode> ways(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = ways(start, i - 1);
            List<TreeNode> right = ways(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
