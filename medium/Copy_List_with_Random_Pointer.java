package medium;


class CNode {
    int val;
    CNode next;
    CNode random;

    public CNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


/**
 * 138. Copy List with Random Pointer
 */



public class Copy_List_with_Random_Pointer {
    public CNode copyRandomList(CNode head) {
        if (head == null) {
            return null;
        }
        CNode cur = head;
        while (cur != null) { //create one node and insert it after each node in the list (1->1'->2->2'->3->3'->null)
            CNode temp = new CNode(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }

        cur = head;
        while (cur != null) { //set each copied node's random pointer
            CNode temp = cur.next;
            if (cur.random != null) {
                temp.random = cur.random.next;
            }
            cur = temp.next;
        }

        CNode p = head;
        CNode pCloneHead = head.next;
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
