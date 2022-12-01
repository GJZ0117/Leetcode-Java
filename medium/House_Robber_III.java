package medium;

/**
 * 337. House Robber III
 */

public class House_Robber_III {
    //https://leetcode.cn/problems/house-robber-iii/solution/shu-xing-dp-by-enda-2/
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    // for each array {x, y}, x represents if not robbing current node's profit, y represents if robbing current node's profit
    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // for root's left child, when not robbing left child we can get left[0] profit, when robbing left child we can get left[1] profit
        int[] left = dp(root.left);
        // for root's right child, when not robbing right child we can get left[0] profit, when robbing right child we can get left[1] profit
        int[] right = dp(root.right);
        // if not robbing current root we can get the maxmium profit of robbing left child or not + roobing right child or not
        // if robbing current root we can get the maxium profit of current value + not robbing left child + not robbing right child
        return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]), root.val + left[0] + right[0]};
    }
}
