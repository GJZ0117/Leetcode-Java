package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. Flatten Binary Tree to Linked List
 */

public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i=0; i<list.size()-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    public static void preOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            if (root.left != null) {
                preOrder(root.left, list);
            }
            if (root.right != null) {
                preOrder(root.right, list);
            }
        }
    }
}
