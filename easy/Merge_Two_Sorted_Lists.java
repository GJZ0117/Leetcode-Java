package easy;

/**
 * 21. Merge Two Sorted Lists
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return " " + val;
    }
}

public class Merge_Two_Sorted_Lists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, null);
        ListNode l3 = new ListNode(5, null);
        ListNode l4 = new ListNode(1, null);
        ListNode l5 = new ListNode(3, null);
        ListNode l6 = new ListNode(4, null);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode head = mergeTwoLists(l1, l4);
        show(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    public static void show(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode);
            listNode = listNode.next;
        }
    }


    // 二刷
    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return newHead.next;
    }
}
