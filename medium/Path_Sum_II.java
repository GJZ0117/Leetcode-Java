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


    public List<List<Integer>> pathSum_2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrder(root, targetSum, 0, res, new ArrayList<>());
        return res;
    }

    private void preOrder(TreeNode node, int targetSum, int curSum, List<List<Integer>> res, List<Integer> list) {
        list.add(node.val);

        if (node.left == null && node.right == null) {
            if (curSum + node.val == targetSum) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        if (node.left != null) {
            preOrder(node.left, targetSum, curSum + node.val, res, list);
        }

        if (node.right != null) {
            preOrder(node.right, targetSum, curSum + node.val, res, list);
        }

        list.remove(list.size() - 1);
    }
}
