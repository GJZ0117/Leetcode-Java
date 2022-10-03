package hard;

/**
 * 25. Reverse Nodes in k-Group
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
        return "" + val;
    }
}

public class Reverse_Nodes_in_k_Group {

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

        ListNode head = reverseKGroup(l1, 3);
        show(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0, head); //创建头节点，使得对所有节点操作一致
        int len = 0; //记录链表中节点数
        while (head != null) {
            len++;
            head = head.next;
        }
        int times = len / k; //节点数除以每个反转小节中的节点数，表示总共需要反转多少次
        int i; //临时变量i用于每次反转完一个小节后，找到已反转的链表中最后一个节点（相当于下一个反转小节的头节点）

        ListNode tempHead = newHead; //每个反转小节的头节点
        ListNode cur = newHead.next; //用cur遍历每个反转小节中所有节点

        while (times > 0) {
            cur = headInsert(tempHead, cur, k); //反转一个小节，返回下一个未反转小节的第一个节点
            i = k; //重置临时变量i
            while (i > 0) { //从刚才已反转的小节中找到最后一个节点（也就是下一个未反转小节的头节点）
                tempHead = tempHead.next;
                i--;
            }
            times--; //反转次数减一
        }
        tempHead.next = cur; //如果无法整除，将已反转小节的最后一个节点和未反转部分的第一个节点连起来
        return newHead.next;
    }

    public static ListNode headInsert(ListNode head, ListNode cur, int k) { //头插法反转一个小节的所有节点
        ListNode p = null;
        while (k > 0) {
            p = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = p;
            k--;
        }
        return p; //返回未反转部分的第一个节点
    }


    public static void show(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode);
            listNode = listNode.next;
        }
    }
}
