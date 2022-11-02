package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 */

public class Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        search(ans, list, root, targetSum);
        return ans;
    }

    public void search(List<List<Integer>> ans, List<Integer> list, TreeNode root, int remain) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (remain == root.val) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        if (root.left != null) {
            search(ans, list, root.left, remain - root.val);
        }

        if (root.right != null) {
            search(ans, list, root.right, remain - root.val);
        }

        list.remove(list.size() - 1);
    }

}
