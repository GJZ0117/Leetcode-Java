package medium;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 */

public class Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    public int pseudoPalindromicPaths(TreeNode root) {
        preOrder(root, new int[10]);
        return ans;
    }

    int ans = 0;

    public void preOrder(TreeNode node, int[] arr) {
        if (node == null) {
            return;
        }
        arr[node.val]++;
        if (node.left == null && node.right == null) {
            if (check(arr)) {
                ans++;
            }
        }

        preOrder(node.left, arr);
        preOrder(node.right, arr);
        arr[node.val]--;
    }

    public boolean check(int[] arr) {
        int oddCount = 0;
        for (int j : arr) {
            if (j % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount == 0 || oddCount == 1;
    }
}
