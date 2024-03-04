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
            while (cur.next != null && cur.val == cur.next.val) { // if current node's value equals to next node's value, leap current node
                cur = cur.next;
            }

            if (pre.next == cur) { // do not have duplicates, move to next node
                pre = pre.next;
            } else { // have duplicates, throw them
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }


    // 二刷
    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        boolean isDuplicate = false;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                isDuplicate = true;
                cur = cur.next;
            }

            if (isDuplicate) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }

            isDuplicate = false;
        }
        return newHead.next;
    }


    // 三刷
    public ListNode deleteDuplicates_3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        while (cur != null) {
            boolean isDuplicated = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                isDuplicated = true;
            }
            if (isDuplicated) {
                cur = cur.next;
                pre.next= cur;
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
