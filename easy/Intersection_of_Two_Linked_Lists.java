package easy;

/**
 * 160. Intersection of Two Linked Lists
 */

public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // calculate listA and listB's length
        int lenA = 0;
        int lenB = 0;
        ListNode temp = headA;
        while (temp != null) {
            lenA++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            lenB++;
            temp = temp.next;
        }

        if (lenA > lenB) { // make sure listA is shorter than listB
            temp = headA;
            headA = headB;
            headB = temp;
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
        }

        int diff = lenB - lenA;
        while (diff > 0) {
            headB = headB.next;
            diff--;
        }

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }


    // 二刷
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode cur = headA;
        while (cur != null) {
            cur = cur.next;
            len1++;
        }
        cur = headB;
        while (cur != null) {
            cur = cur.next;
            len2++;
        }
        if (len1 < len2) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int diff = Math.abs(len1 - len2);
        while (diff > 0 && headA != null) {
            headA = headA.next;
            diff--;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
