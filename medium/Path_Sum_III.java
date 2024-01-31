package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 */

public class Path_Sum_III {
    public int pathSum(TreeNode root, int targetSum) {
        int[] path = {0};

        if (root != null) {
            preOrder(root, targetSum, 0, path);
            path[0] += pathSum(root.left, targetSum);
            path[0] += pathSum(root.right, targetSum);
        }

        return path[0];
    }

    public void preOrder(TreeNode cur, int targetSum, long curSum, int[] path) {
        if (cur != null) {
            long sum = curSum + cur.val;
            if (sum == (long) targetSum) {
                path[0]++;
            }
            preOrder(cur.left, targetSum, sum, path);
            preOrder(cur.right, targetSum, sum, path);
        }
    }


    // 二刷
    // https://leetcode.cn/problems/path-sum-iii/solutions/596361/dui-qian-zhui-he-jie-fa-de-yi-dian-jie-s-dey6/?show=1
    public int pathSum_2(TreeNode root, int targetSum) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0L, 1);
        return dfs(root, targetSum, 0L, preSumMap);
    }

    public int dfs(TreeNode root, long target, Long curSum, Map<Long, Integer> preSumMap) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        curSum += (long) root.val;

        ans += preSumMap.getOrDefault(curSum - target, 0);
        preSumMap.put(curSum, preSumMap.getOrDefault(curSum, 0) + 1);
        int left = dfs(root.left, target, curSum, preSumMap);
        int right = dfs(root.right, target, curSum, preSumMap);
        ans = ans + left + right;
        preSumMap.put(curSum, preSumMap.get(curSum) - 1);
        return ans;
    }
}
