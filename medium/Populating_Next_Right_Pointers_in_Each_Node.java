package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int len;
        Node p;
        while (!queue.isEmpty()) {
            len = queue.size();
            while (len > 0) {
                p = queue.poll();
                len--;
                if (len > 0) {
                    p.next = queue.peek();
                } else {
                    p.next = null;
                }

                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
        }
        return root;
    }
}
