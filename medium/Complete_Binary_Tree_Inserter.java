package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 919. Complete Binary Tree Inserter
 */

public class Complete_Binary_Tree_Inserter {
    class CBTInserter {
        TreeNode root = null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            deque.add(this.root);
            TreeNode p;
            while (!deque.isEmpty()) {
                int len = deque.size();
                while (len > 0) {
                    p = deque.pollFirst();
                    if (p.left == null || p.right == null) {
                        deque2.add(p);
                    }
                    if (p.left != null) {
                        deque.add(p.left);
                    }
                    if (p.right != null) {
                        deque.add(p.right);
                    }
                    len--;
                }
            }
        }

        public int insert(int val) {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            newNode.left = null;
            newNode.right = null;
            TreeNode p = deque2.peekFirst();
            if (p.left == null) {
                p.left = newNode;
            } else {
                p.right = newNode;
                deque2.pollFirst();
            }
            deque2.add(newNode);
            return p.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
