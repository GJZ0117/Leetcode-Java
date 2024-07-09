package medium;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 */

public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int times = 0;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                times++;
                if (k == times) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }


    // 二刷
    public int kthSmallest_2(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    int ans = 0;
    int count = 0;

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        count++;
        if (count == k) {
            ans = node.val;
        }
        inOrder(node.right, k);
    }
}
