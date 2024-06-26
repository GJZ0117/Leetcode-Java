package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 971. Flip Binary Tree To Match Preorder Traversal
 */

public class Flip_Binary_Tree_To_Match_Preorder_Traversal {
    int vIndex = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        if (dfs(root, voyage, res)) {
            return res;
        }
        return Arrays.asList(-1);
    }

    public boolean dfs(TreeNode node, int[] voyage, List<Integer> res) {
        if (node == null) {
            return true;
        }
        if (node.val != voyage[vIndex++]) {
            return false;
        }
        if (node.left != null && node.left.val != voyage[vIndex]) {
            res.add(node.val);
            return dfs(node.right, voyage, res) && dfs(node.left, voyage, res);
        }
        return dfs(node.left, voyage, res) && dfs(node.right, voyage, res);
    }


    // 二刷

    public List<Integer> flipMatchVoyage_2(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        if (!dfsTraversal(root, voyage, res)) {
            res.clear();
            res.add(-1);
            return res;
        } else {
            return res;
        }
    }

    int index = 0;

    public boolean dfsTraversal(TreeNode node, int[] voyage, List<Integer> res) {
        if (node == null) {
            return true;
        }
        int pre = index;
        if (node.val != voyage[index++]) {
            return false;
        }
        if (dfsTraversal(node.left, voyage, res) && dfsTraversal(node.right, voyage, res)) {
            return true;
        }
        index = pre + 1;
        boolean left = dfsTraversal(node.right, voyage, res);
        boolean right = dfsTraversal(node.left, voyage, res);
        if (left && right) {
            res.add(node.val);
        }
        return left && right;
    }
}
