package medium;

/*
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
 * 138. Copy List with Random Pointer
 */

import org.w3c.dom.Node;

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) { //create one node and insert it after each node in the list (1->1'->2->2'->3->3'->null)
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }

        cur = head;
        while (cur != null) { //set each copied node's random pointer
            Node temp = cur.next;
            if (cur.random != null) {
                temp.random = cur.random.next;
            }
            cur = temp.next;
        }

        Node p = head;
        Node pCloneHead = head.next;
        cur = pCloneHead;
        while (p!=null) { //reconnect two list (1->2->3->null, 1'->2'->3'->null)
            p.next = cur.next;
            if (cur.next!=null){
                cur.next = cur.next.next;
            }
            p = p.next;
            cur = cur.next;
        }
        return pCloneHead;
    }
}
