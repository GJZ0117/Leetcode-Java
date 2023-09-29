package medium;

/**
 * 86. Partition List
 */

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) { // lower cases put into list1
                temp1.next = cur;
                temp1 = temp1.next;
                cur = cur.next;
                temp1.next = null;
            } else { // higher cases put into list2
                temp2.next = cur;
                temp2 = temp2.next;
                cur = cur.next;
                temp2.next = null;
            }
        }
        temp1.next = list2.next; // connect list1 and list2
        return list1.next;
    }


    // 二刷
    public ListNode partition_2(ListNode head, int x) {
        ListNode originalHead = new ListNode();
        originalHead.next = head;
        ListNode newHead = new ListNode();
        ListNode originalPointer = originalHead;
        ListNode newPointer = newHead;
        while (originalPointer.next != null) {
            if (originalPointer.next.val < x) {
                newPointer.next = originalPointer.next;
                newPointer = newPointer.next;
                originalPointer.next = originalPointer.next.next;
            } else {
                originalPointer = originalPointer.next;
            }
        }
        newPointer.next = originalHead.next;
        return newHead.next;
    }
}
