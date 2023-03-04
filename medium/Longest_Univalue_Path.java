package medium;

/**
 * 687. Longest Univalue Path
 */

public class Longest_Univalue_Path {

    private int longestLength = 1;

    public int longestUnivaluePath(TreeNode root) {
        postOrder(root);
        return longestLength - 1;
    }

    public int postOrder(TreeNode node) {
        if (node != null) {
            int leftChildLength = postOrder(node.left);
            int rightChildLength = postOrder(node.right);

            int curLongestLength = 1;
            boolean isTwoChildrenAndRootSame = false;
            if (node.left != null && node.val == node.left.val && node.right != null && node.val == node.right.val) {
                curLongestLength = leftChildLength + rightChildLength + 1;
                isTwoChildrenAndRootSame = true;
            } else if (node.left != null && node.val == node.left.val) {
                curLongestLength = leftChildLength + 1;
            } else if (node.right != null && node.val == node.right.val) {
                curLongestLength = rightChildLength + 1;
            }
            longestLength = Math.max(longestLength, curLongestLength);
            if (isTwoChildrenAndRootSame) {
                return Math.max(leftChildLength, rightChildLength) + 1;
            } else {
                return curLongestLength;
            }
        } else {
            return 0;
        }
    }
}
