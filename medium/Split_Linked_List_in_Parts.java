package medium;

/**
 * 725. Split Linked List in Parts
 */

public class Split_Linked_List_in_Parts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int index = 0;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int eachItemLen = len / k;
        int eachItemNum = k;
        if (eachItemLen == 0 || (len - eachItemLen * k != 0)) {
            eachItemLen++;
            eachItemNum = len % k;
        }

        cur = head;
        while (index < k) {
            ans[index++] = cur;
            if (eachItemNum > 0) {
                int temp = 1;
                while (temp < eachItemLen) {
                    cur = cur.next;
                    temp++;
                }
                if (cur != null) {
                    ListNode p = cur.next;
                    cur.next = null;
                    cur = p;
                }
                eachItemNum--;
                if (eachItemNum == 0) {
                    eachItemLen--;
                }
            } else if (eachItemLen == 0) {
                cur = null;
            } else {
                int temp = 1;
                while (temp < eachItemLen) {
                    cur = cur.next;
                    temp++;
                }
                if (cur != null) {
                    ListNode p = cur.next;
                    cur.next = null;
                    cur = p;
                }
            }
        }
        return ans;
    }
}
