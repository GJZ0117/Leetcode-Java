package medium;

/**
 * 328. Odd Even Linked List
 */

public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode cur = head;
        ListNode oddHeadPointer = oddHead;
        ListNode evenHeadPointer = evenHead;
        int times = 1;
        while (cur != null) {
            if (times % 2 == 0) {
                evenHeadPointer.next = cur;
                evenHeadPointer = evenHeadPointer.next;
            } else {
                oddHeadPointer.next = cur;
                oddHeadPointer = oddHeadPointer.next;
            }
            cur = cur.next;
            times++;
        }
        evenHeadPointer.next = null;
        oddHeadPointer.next = evenHead.next;
        return oddHead.next;
    }
}
