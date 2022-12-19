package medium;


/**
 * 430. Flatten a Multilevel Doubly Linked List
 */


public class Flatten_a_Multilevel_Doubly_Linked_List {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node temp = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) {
                    childLast.next = temp;
                }
                if (temp != null) {
                    temp.prev = childLast;
                }
                head = childLast;
            }
        }
        return last;
    }
}
