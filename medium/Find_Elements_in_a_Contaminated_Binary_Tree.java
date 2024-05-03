package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 */

public class Find_Elements_in_a_Contaminated_Binary_Tree {
    class FindElements {

        Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            preOrder(root);
        }

        public void preOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.val == -1) {
                node.val = 0;
            }
            set.add(node.val);
            if (node.left != null) {
                node.left.val = 2 * node.val + 1;
                preOrder(node.left);
            }
            if (node.right != null) {
                node.right.val = 2 * node.val + 2;
                preOrder(node.right);
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
