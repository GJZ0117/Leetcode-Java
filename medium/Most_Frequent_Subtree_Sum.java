package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 */

public class Most_Frequent_Subtree_Sum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        postOrder(root, map);
        int maxFrequency = 0;
        int len = 0;
        for (int frequency : map.values()) {
            if (maxFrequency < frequency) {
                maxFrequency = frequency;
                len = 1;
            } else if (maxFrequency == frequency) {
                len++;
            }
        }

        int[] ans = new int[len];
        int index = 0;
        for (int key : map.keySet()) {
            if (maxFrequency == map.get(key)) {
                ans[index++] = key;
            }
        }
        return ans;
    }

    public int postOrder(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int leftChildTree = postOrder(node.left, map);
        int rightChildTree = postOrder(node.right, map);
        int cur = node.val + leftChildTree + rightChildTree;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }
}
