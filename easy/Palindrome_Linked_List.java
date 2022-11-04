package easy;

/**
 * 234. Palindrome Linked List
 */

public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);

        while (slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode cur=head;
        while (cur != null) {
            head = head.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = head;
        }
        return newHead.next;
    }
}
