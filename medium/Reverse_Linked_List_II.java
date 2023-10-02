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


    // 二刷
    public ListNode reverseBetween_2(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        int count = right - left;
        ListNode cur = newHead;
        ListNode start = null;
        ListNode end = null;
        ListNode first = null;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }
        start = cur;
        for (int i = 0; i <= count; i++) {
            cur = cur.next;
        }
        end = cur.next;
        cur = start.next;
        start.next = null;
        ListNode temp;
        for (int i = 0; i <= count; i++) {
            if (first == null) {
                first = cur;
            }
            temp = cur.next;
            cur.next = start.next;
            start.next = cur;
            cur = temp;
        }
        first.next = end;
        return newHead.next;
    }
}
