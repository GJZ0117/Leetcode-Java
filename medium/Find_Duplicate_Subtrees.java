package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 */

public class Find_Duplicate_Subtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        String key = new StringBuilder().append(node.val).append(",").append(dfs(node.left)).append(",").append(dfs(node.right)).toString();
        if (map.getOrDefault(key, 0) == 1) {
            result.add(node);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}
