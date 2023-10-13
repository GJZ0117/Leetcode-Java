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



    // 二刷（还不会）
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        return generate(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode generate(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preStart >= preOrder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = generate(preStart + 1, inStart, inIndex - 1, preOrder, inOrder);
        root.right = generate(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preOrder, inOrder);
        return root;
    }
}
