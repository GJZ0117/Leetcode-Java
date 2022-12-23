package medium;

/**
 * 445. Add Two Numbers II
 */

public class Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] len1 = {0};
        int[] len2 = {0};
        l1 = reverseList(l1, len1);
        l2 = reverseList(l2, len2);
        if (len1[0] < len2[0]) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode head = l1;
        ListNode tail = l1;
        boolean flag = false;

        while (l2 != null) {
            int value1 = l1.val;
            int value2 = l2.val;
            int sum = value1 + value2 + (flag ? 1 : 0);
            if (sum > 9) {
                flag = true;
                l1.val = sum % 10;
            } else {
                flag = false;
                l1.val = sum;
            }
            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (flag && l1 != null) {
            int sum = l1.val + 1;
            if (sum > 9) {
                flag = true;
                l1.val = sum % 10;
            } else {
                flag = false;
                l1.val = sum;
            }
            tail = l1;
            l1 = l1.next;
        }

        if (flag) {
            ListNode node = new ListNode();
            node.val = 1;
            tail.next = node;
        }

        head = reverseList(head, len1);
        return head;
    }

    public ListNode reverseList(ListNode pre, int[] len) {
        ListNode tail = pre;
        ListNode cur = pre.next;
        ListNode next;
        while (cur != null) {
            len[0]++;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        tail.next = null;
        return pre;
    }
}
