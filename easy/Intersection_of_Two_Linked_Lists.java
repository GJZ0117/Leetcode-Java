package easy;

/**
 * 160. Intersection of Two Linked Lists
 */

public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //calculate listA and listB's length
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

        if (lenA > lenB) { //make sure listA is shorter than listB
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

        while (headA!=null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
