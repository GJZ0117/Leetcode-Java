package medium;

/**
 * 92. Reverse Linked List II
 */

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int diff = right - left + 1;
        if (diff == 1) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode preBegin = newHead;
        ListNode end = newHead;
        while (diff != 0) {
            end = end.next;
            diff--;
        }
        while (left > 1) {
            preBegin = preBegin.next;
            end = end.next;
            left--;
        }
        ListNode reverseStart = preBegin.next;
        preBegin.next = end.next;
        end.next = null;

        while (reverseStart != null) {
            ListNode tempNode = reverseStart;
            reverseStart = reverseStart.next;
            tempNode.next = preBegin.next;
            preBegin.next = tempNode;
        }
        return newHead.next;
    }
}
