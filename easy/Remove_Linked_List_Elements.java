package easy;

/**
 * 203. Remove Linked List Elements
 */

public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val) {
                pre.next = pre.next.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
