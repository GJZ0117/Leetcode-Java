package easy;

/**
 * 876. Middle of the Linked List
 */

public class Middle_of_the_Linked_List {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, null);
        ListNode l3 = new ListNode(3, null);
        ListNode l4 = new ListNode(4, null);
        ListNode l5 = new ListNode(5, null);
        ListNode l6 = new ListNode(6, null);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode head = middleNode(l1);
        Merge_Two_Sorted_Lists.show(head);
    }

    public static ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        boolean isOdd = false;
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
            if (cur.next == null) {
                isOdd = true;
                break;
            } else {
                cur = cur.next;
            }
        }
        if (isOdd) {
            return pre;
        }
        return pre.next;
    }

}
