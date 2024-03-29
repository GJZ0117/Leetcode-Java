package easy;

/**
 * 206. Reverse Linked List
 */

public class Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, null);
        ListNode l3 = new ListNode(3, null);
        ListNode l4 = new ListNode(4, null);
        ListNode l5 = new ListNode(5, null);
        ListNode l6 = new ListNode(6, null);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode head = reverseList(l1);
        Merge_Two_Sorted_Lists.show(head);
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode();
        h.next = head;
        ListNode cur = head;
        ListNode p;

        while (cur.next != null) {
            p = cur.next.next;
            cur.next.next = h.next;
            h.next = cur.next;
            cur.next = p;
        }
        return h.next;
    }


    // 二刷
    public ListNode reverseList_2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}
