package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return createTree(postorder, map, 0, postorder.length - 1, 0);
    }

    public TreeNode createTree(int[] postorder, Map<Integer, Integer> map, int postStart, int postEnd, int inStart) {
        if (postEnd < postStart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = map.get(root.val);
        int leftChildTreeNum = rootIndex - inStart;
        root.left = createTree(postorder, map, postStart, postStart + leftChildTreeNum - 1, inStart);
        root.right = createTree(postorder, map, postStart + leftChildTreeNum, postEnd - 1, rootIndex + 1);
        return root;
    }


    // 二刷（还不会）
    public TreeNode buildTre_2(int[] inorder, int[] postorder) {
        return generate(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode generate(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inIndex = inStart;
        while (inOrder[inIndex] != root.val) {
            inIndex++;
        }
        int countLeftNodes = inIndex - inStart;
        root.left = generate(inOrder, inStart, inIndex - 1, postOrder, postStart, postStart + countLeftNodes - 1);
        root.right = generate(inOrder, inIndex + 1, inEnd, postOrder, postStart + countLeftNodes, postEnd - 1);
        return root;
    }
}
