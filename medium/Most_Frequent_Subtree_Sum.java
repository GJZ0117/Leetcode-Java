package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


    // 二刷
    public int[] findFrequentTreeSum_2(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        postOrderTraversal(root, map);
        int maxFrequency = 0;
        for (int frequency : map.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFrequency) {
                list.add(key);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int postOrderTraversal(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int left = postOrderTraversal(node.left, map);
        int right = postOrderTraversal(node.right, map);
        int cur = left + right + node.val;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }
}
