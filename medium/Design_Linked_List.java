package medium;

/**
 * 707. Design Linked List
 */

public class Design_Linked_List {
    class MyLinkedList {

        class Node {
            public int val;
            public Node pre;
            public Node next;
        }

        private Node head;

        public MyLinkedList() {
            head = new Node();
        }

        public int get(int index) {
            int i = 0;
            Node p = head.next;
            while (p != null && i < index) {
                p = p.next;
                i++;
            }
            if (p != null && i == index) {
                return p.val;
            } else {
                return -1;
            }
        }

        public void addAtHead(int val) {
            Node p = new Node();
            p.val = val;
            p.next = head.next;
            p.pre = head;
            if (head.next != null) {
                head.next.pre = p;
            }
            head.next = p;
        }

        public void addAtTail(int val) {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            Node p = new Node();
            p.val = val;
            p.next = cur.next;
            p.pre = cur;
            cur.next = p;
        }

        public void addAtIndex(int index, int val) {
            int i = 0;
            Node cur = head;
            while (cur.next != null && i < index) {
                cur = cur.next;
                i++;
            }
            if (cur.next != null && i == index) {
                Node p = new Node();
                p.val = val;
                p.next = cur.next;
                p.pre = cur;
                cur.next.pre = p;
                cur.next = p;
            } else if (cur.next == null && i == index) {
                Node p = new Node();
                p.val = val;
                p.next = cur.next;
                p.pre = cur;
                cur.next = p;
            }
        }

        public void deleteAtIndex(int index) {
            int i = 0;
            Node cur = head;
            while (cur.next != null && i < index) {
                cur = cur.next;
                i++;
            }
            if (cur.next != null && i == index) {
                cur.next = cur.next.next;
            }
        }
    }
}
