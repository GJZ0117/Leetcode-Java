package medium;

/**
 * 82. Remove Duplicates from Sorted List II
 */

public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) { //if current node's value equals to next node's value, leap current node
                cur = cur.next;
            }

            if (pre.next == cur) { //do not have duplicates, move to next node
                pre = pre.next;
            } else { // have duplicates, throw them
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
