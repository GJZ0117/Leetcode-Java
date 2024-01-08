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


    // 二刷
    public ListNode oddEvenList_2(ListNode head) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode cur = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int count = 1;
        while (cur != null) {
            if (count % 2 == 1) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            count++;
            cur = cur.next;
            cur2.next = null;
        }
        cur1.next = l2.next;
        return l1.next;
    }
}
