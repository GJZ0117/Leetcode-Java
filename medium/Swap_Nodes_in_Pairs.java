package medium;

/**
 * 24. Swap Nodes in Pairs
 */

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode();
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;

        while (cur != null && cur.next !=null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return h.next;
    }
}
