package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */

public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }
        search(ans, new ArrayList<>(), root);
        return ans;
    }

    public void search(List<String> ans, List<Integer> list, TreeNode root) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i));
                sb.append("->");
            }
            sb.append(list.get(list.size() - 1));
            ans.add(sb.toString());
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            search(ans, list, root.left);
        }
        if (root.right != null) {
            search(ans, list, root.right);
        }
        list.remove(list.size() - 1);
    }


    // 二刷
    public List<String> binaryTreePaths_2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        dfs(root, list, new ArrayList<>());
        return list;
    }

    public void dfs(TreeNode node, List<String> list, List<Integer> path) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append("->");
                }
            }
            list.add(sb.toString());
        }
        if (node.left != null) {
            dfs(node.left, list, path);
        }
        if (node.right != null) {
            dfs(node.right, list, path);
        }
        path.remove(path.size() - 1);
    }
}
