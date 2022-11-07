package medium;

/**
 * 147. Insertion Sort List
 */

public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode pre;
        ListNode temp;
        ListNode cur = head.next;
        head.next = null;
        newHead.val = Integer.MIN_VALUE;
        newHead.next = head;
        while (cur != null) {
            pre = newHead;
            temp = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        return newHead.next;
    }
}
