package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(); //use map to record values and their indexes in inorder array
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return createTree(preorder, map, 0, preorder.length - 1, 0);
    }

    public static TreeNode createTree(int[] preorder, Map<Integer, Integer> map, int preStart, int preEnd, int inStart) {
        if (preEnd < preStart) { //recrusion border
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]); //use the first value in preorder array to create current root node
        int rootIndex = map.get(root.val); //find current root's index in inorder array
        int leftChildTreeNum = rootIndex - inStart; //current root's left child tree's node num
        root.left = createTree(preorder, map, preStart + 1, preStart + leftChildTreeNum, inStart); //left child tree's recrusion
        root.right = createTree(preorder, map, preStart + leftChildTreeNum + 1, preEnd, rootIndex + 1); //right child tree's recrusion
        return root;
    }
}
