package medium;

/**
 * 2. Add Two Numbers
 */

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

public class Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp; //记录l1和l2对应节点值相加的结果
        ListNode listNode, cur; //listNode为最终要返回的头节点, cur用于后续保存循环退出时较长链表指针停留的位置
        ListNode list1 = l1, list2 = l2;
        boolean flag = false; //用于记录是否有进位
        while (list1 != null && list2 != null) {
            temp = list1.val + list2.val;
            if (flag) { //前一位相加的结果有进位，本位结果+1
                temp++;
            }
            flag = false; //重置进位标志
            if (temp > 9) { //本位相加后结果有进位
                flag = true;
                temp = temp - 10;
            }
            list1.val = temp;
            list2.val = temp;
            list1 = list1.next;
            list2 = list2.next;
        }

        if (list1 == null) { //listNode指向较长的链表（最终要返回的链表），cur指向循环退出时该链表指针的位置
            listNode = l2;
            cur = list2;
        } else {
            listNode = l1;
            cur = list1;
        }

        if (flag && cur != null) { //循环退出后仍有进位，并且退出时较长链表的指针非空

            while (cur != null) { //该位+1并一次检查是否有进位
                if (flag) {
                    cur.val++;
                }
                flag = false;
                if (cur.val > 9) {
                    flag = true;
                    cur.val = cur.val - 10;
                }
                cur = cur.next;
            }
            if (flag && cur == null) { //到最后一位仍有仅为，需新生成一个节点
                ListNode p = listNode;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = new ListNode(1, null);
            }

        } else if (flag && cur == null) { //有进位，且循环退出时较长链表指针指到了最后一位（空），徐新生成一个节点
            ListNode p = listNode;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new ListNode(1, null);
        }

        return listNode;
    }

    // 二刷
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode node = l1;
        while (node != null) {
            len1++;
            node = node.next;
        }
        node = l2;
        while (node != null) {
            len2++;
            node = node.next;
        }
        if (len1 < len2) {
            node = l1;
            l1 = l2;
            l2 = node;
        }
        node = l1;
        boolean flag = false;
        ListNode pre = l1;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + (flag ? 1 : 0);
            if (val >= 10) {
                flag = true;
                val = val % 10;
            } else {
                flag = false;
            }
            l1.val = val;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && flag) {
            int val = l1.val + 1;
            if (val >= 10) {
                flag = true;
                val = val % 10;
            } else {
                flag = false;
            }
            l1.val = val;
            pre = l1;
            l1 = l1.next;
        }
        if (flag) {
            l1 = new ListNode();
            l1.val = 1;
            l1.next = null;
            pre.next = l1;
        }
        return node;
    }
}
