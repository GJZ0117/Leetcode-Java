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
        ListNode cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = head;
        }
        return newHead.next;
    }


    // 二刷
    public boolean isPalindrome_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode newHead = new ListNode();
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = newHead.next;
            newHead.next = slow;
            slow = temp;
        }

        slow = newHead.next;

        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return slow == null;
    }
}
