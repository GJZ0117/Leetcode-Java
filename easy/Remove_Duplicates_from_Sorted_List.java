package easy;

/**
 * 83. Remove Duplicates from Sorted List
 */

public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


    // 二刷
    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            cur = pre.next;
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}
