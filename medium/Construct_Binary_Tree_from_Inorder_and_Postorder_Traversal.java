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
}
