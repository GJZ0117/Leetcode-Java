package medium;

/**
 * 148. Sort List
 */

public class Sort_List {

    public ListNode betterSolution(ListNode head) {
        return betterSolution(head, null);
    }
    public ListNode betterSolution(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast!=tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = betterSolution(head, mid);
        ListNode list2 = betterSolution(mid, tail);
        ListNode sorted = mergeTwoLists(list1, list2);
        return sorted;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 == null ? list2 : list1);
        return head.next;
    }

    //Time Limit Exceeded
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode();
        h.val = Integer.MIN_VALUE;
        h.next = head;
        ListNode sortedLast = head;
        ListNode cur = head.next;

        while (cur != null) {
            sortedLast.next = sortedLast.next.next;
            ListNode temp = h;
            boolean isChange = false;
            while (temp != sortedLast) {
                if (temp.val <= cur.val && temp.next.val > cur.val) {
                    cur.next = temp.next;
                    temp.next = cur;
                    isChange = true;
                    break;
                }
                temp = temp.next;
            }
            if (!isChange) {
                cur.next = sortedLast.next;
                sortedLast.next = cur;
                sortedLast = sortedLast.next;
            }
            cur = sortedLast.next;
        }
        return h.next;
    }
}
