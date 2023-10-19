package medium;

import java.util.ArrayDeque;
import java.util.Deque;
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

    // find each node's father node and check its father's next pointer
    public Node betterSolution(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null) return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }


    //cost too much space
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


    // 二刷
    public Node connect_2(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        int len;
        Node p;
        if (root != null) {
            deque.addLast(root);
        }
        while (!deque.isEmpty()) {
            len = deque.size();
            while (len > 0) {
                len--;
                p = deque.removeFirst();
                if (len == 0) {
                    p.next = null;
                } else {
                    p.next = deque.peekFirst();
                }
                if (p.left != null) {
                    deque.addLast(p.left);
                }
                if (p.right != null) {
                    deque.addLast(p.right);
                }
            }
        }
        return root;
    }
}
