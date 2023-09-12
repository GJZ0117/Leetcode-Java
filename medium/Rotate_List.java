package medium;

/**
 * 61. Rotate List
 */

public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        tail.next = head; // make a circle (tail -> head)
        ListNode pre = tail; // previous of the head

        if (len < k) { // calculate where to cut
            int temp = k / len;
            len = len * (temp + 1);
        }
        int times = len - k;

        while (times > 0) { // find where to cut
            pre = head;
            head = head.next;
            times--;
        }
        pre.next = null;
        return head;
    }


    // 二刷
    public ListNode rotateRight_2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode node = head;
        ListNode tail = head;
        while (node != null) {
            tail = node;
            node = node.next;
            len++;
        }


        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode newHead = new ListNode();
        node = head;
        int index = 1;
        while (index < len - k) {
            node = node.next;
            index++;
        }
        newHead.next = node.next;
        node.next = null;
        tail.next = head;
        return newHead.next;
    }
}
