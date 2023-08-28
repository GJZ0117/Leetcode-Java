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

        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return h.next;
    }


    //二刷
    public ListNode swapPairs_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        ListNode tempHead;
        while (head != null && head.next != null) {
            tempHead = head.next.next;
            cur.next = head.next;
            cur = cur.next;
            cur.next = head;
            cur = cur.next;
            cur.next = null;
            head = tempHead;
        }
        if (head != null) {
            cur.next = head;
            cur = cur.next;
            cur.next = null;
        }
        return newHead.next;
    }
}
