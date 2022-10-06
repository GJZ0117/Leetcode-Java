package medium;

/**
 * 142. Linked List Cycle II
 */

public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == null || fast == null || fast.next == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
