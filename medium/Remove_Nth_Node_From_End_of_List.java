package medium;

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
        return ""+this.val;
    }
}


public class Remove_Nth_Node_From_End_of_List {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        listNode1 = removeNthFromEnd(listNode1, 3);

        while (listNode1 != null){
            System.out.print(listNode1);
            listNode1 = listNode1.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null; //链表中只有一个节点并删除该节点

        int[] num = {0}; //此处为了传递引用类型变量，故意设置一个数组

        ListNode listNode = new ListNode(); //设置一个头节点，使得删除链表中任意节点的操作相同
        listNode.next = head;

        remove(listNode, n, num);

        return listNode.next; //返回头节点指向的下一个节点
    }

    public static void remove(ListNode cur, int n, int[] num) { //递归删除倒数第n个节点
        if (cur.next != null && num[0] == 0) { //递归到链表最后一个节点
            remove(cur.next, n, num);
        }
        num[0]++; //给引用类型变量的计数器+1
        if (num[0]-1 == n){ //当计数器-1 == n时表示此时的head指向了需要删除节点的前一个节点
            cur.next = cur.next.next;
        }
    }
}
