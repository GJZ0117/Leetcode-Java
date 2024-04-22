package easy;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 */

public class Sum_of_Root_To_Leaf_Binary_Numbers {

    int sum = 0;
    int[] base = new int[31];

    public int sumRootToLeaf(TreeNode root) {
        int baseNum = 1;
        for (int i = 0; i < 31; i++) {
            base[i] = baseNum;
            baseNum = baseNum * 2;
        }
        preOrder(root, new StringBuilder());
        return sum;
    }

    public void preOrder(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);
            if (node.left == null && node.right == null) {
                int num = 0;
                for (int i = sb.length() - 1; i >= 0; i--) {
                    num += sb.charAt(i) == '0' ? 0 : base[sb.length() - i - 1];
                }
                sum += num;
                return;
            }

            if (node.left != null) {
                preOrder(node.left, sb);
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

            if (node.right != null) {
                preOrder(node.right, sb);
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }


    // 二刷
    public int sumRootToLeaf_2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return ans;
    }

    int ans = 0;

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                int num = 0;
                for (int i = sb.length() - 1; i >= 0; i--) {
                    int cur = sb.charAt(i) == '0' ? 0 : 1;
                    if (cur == 1) {
                        num += (1 << (sb.length() - 1 - i));
                    }
                }
                ans += num;
                return;
            }

            if (root.left != null) {
                dfs(root.left, sb);
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

            if (root.right != null) {
                dfs(root.right, sb);
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
