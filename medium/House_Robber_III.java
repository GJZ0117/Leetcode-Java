package medium;

/**
 * 337. House Robber III
 */

public class House_Robber_III {
    // https://leetcode.cn/problems/house-robber-iii/solution/shu-xing-dp-by-enda-2/
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


    // 二刷（还不会）
    public int rob_2(TreeNode root) {
        int[] result = preOrder(root);
        return Math.max(result[0], result[1]);
    }

    public int[] preOrder(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        // result[0]代表不偷当前节点，result[1]代表偷当前节点
        int[] result = new int[2];
        int[] left = preOrder(root.left);
        int[] right = preOrder(root.right);
        // 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
