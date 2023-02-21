package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 655. Print Binary Tree
 */

public class Print_Binary_Tree {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] ans = new String[height][(int) (Math.pow(2, height) - 1)];
        for (String[] arr : ans) {
            Arrays.fill(arr, "");
        }
        List<List<String>> res = new ArrayList<>();
        fill(ans, root, 0, 0, ans[0].length);
        for (String[] arr : ans) {
            res.add(Arrays.asList(arr));
        }
        return res;
    }

    public void fill(String[][] ans, TreeNode root, int row, int left, int right) {
        if (root == null) {
            return;
        }
        ans[row][(left + right) / 2] = String.valueOf(root.val);
        fill(ans, root.left, row + 1, left, (left + right) / 2);
        fill(ans, root.right, row + 1, (left + right + 1) / 2, right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
