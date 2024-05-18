package easy;

import java.util.*;

/**
 * 501. Find Mode in Binary Search Tree
 */

public class Find_Mode_in_Binary_Search_Tree {

    private TreeNode pre = null;
    private int count = 0;
    private int maxCount = 0;
    List<Integer> list = new LinkedList<>();


    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void inOrder(TreeNode cur) {
        if (cur != null) {
            inOrder(cur.left);

            if (pre == null) {
                count = 1;
            } else if (pre.val == cur.val) {
                count++;
            } else {
                count = 1;
            }
            pre = cur;
            if (count == maxCount) {
                list.add(cur.val);
            } else if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(cur.val);
            }
            inOrder(cur.right);
        }
    }


    // 二刷
    public int[] findMode_2(TreeNode root) {
        dfs(root, new HashMap<>());
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    int maxNum = 0;
    List<Integer> ans = new ArrayList<>();

    public void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        if (map.get(node.val) > maxNum) {
            maxNum = map.get(node.val);
            ans.clear();
            ans.add(node.val);
        } else if (map.get(node.val) == maxNum) {
            ans.add(node.val);
        }
        dfs(node.left, map);
        dfs(node.right, map);
    }
}
