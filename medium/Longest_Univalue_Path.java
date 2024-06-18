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


    // 二刷
    public int longestUnivaluePath_2(TreeNode root) {
        postOrderTraversal(root);
        return maxLen;
    }

    int maxLen = 0;

    public int postOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSameCount = postOrderTraversal(root.left);
        int rightSameCount = postOrderTraversal(root.right);

        int count = 0;
        int res = 0;

        if (root.left != null && root.left.val == root.val) {
            count += leftSameCount + 1;
            res = leftSameCount + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            count += rightSameCount + 1;
            res = Math.max(res, rightSameCount + 1);
        }
        maxLen = Math.max(maxLen, count);
        return res;
    }
}
