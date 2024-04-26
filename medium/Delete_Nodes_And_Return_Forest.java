package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. Delete Nodes And Return Forest
 */

public class Delete_Nodes_And_Return_Forest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }
        if (dfs(ans, root, set) != null) {
            ans.add(root);
        }
        return ans;
    }

    public TreeNode dfs(List<TreeNode> ans, TreeNode node, Set<Integer> set) {
        if (node == null) {
            return null;
        }
        node.left = dfs(ans, node.left, set);
        node.right = dfs(ans, node.right, set);
        if (!set.contains(node.val)) {
            return node;
        }
        if (node.left != null) {
            ans.add(node.left);
        }
        if (node.right != null) {
            ans.add(node.right);
        }
        return null;
    }
}
