package medium;

/**
 * 143. Reorder List
 */

public class Reorder_List {
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        reverse(slow);
        ListNode cur = head;
        ListNode insertHead = slow.next;
        ListNode temp;
        slow.next = null;
        while (insertHead != null) {
            temp = insertHead.next;
            insertHead.next = cur.next;
            cur.next = insertHead;
            cur = cur.next.next;
            insertHead = temp;
        }
    }

    public void reverse(ListNode head) {
        ListNode cur = head.next;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            if (cur == head.next) {
                cur.next = null;
            } else {
                cur.next = head.next;
            }
            head.next = cur;
            cur = temp;
        }
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
