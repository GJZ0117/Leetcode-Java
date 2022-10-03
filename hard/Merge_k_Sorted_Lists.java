package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
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

public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) { //空数组返回null
            return null;
        }
        ListNode head = new ListNode(); //头节点保证对所有节点操作一致
        ListNode cur = head; //遍历并链接所有链表
        ListNode tempMin; //记录每次使用findMin方法找到的集合中最小的节点
        List<ListNode> list = new ArrayList<>();
        for (ListNode node : lists) { //把每个链表中的最小的节点（第一个节点）加入集合
            if (node != null) { //为空的链表（如[[1,2,3], [], []]）直接跳过
                list.add(node);
            }
        }
        while (!list.isEmpty()) { //集合为空说明所有链表的所有节点都遍历过
            tempMin = findMin(list); //找到当前集合中最小的节点
            cur.next = tempMin; //把当前集合中最小节点加到主链表上
            cur = cur.next; //遍历指针移到主链表最后一个节点
            list.remove(tempMin); //从集合中删除刚找出的最小节点
            if (tempMin.next != null) { //若最小节点的下一个节点不为空，则将其加入到集合中
                list.add(tempMin.next);
            }
        }
        return head.next;
    }

    public static ListNode findMin(List<ListNode> list) { //从保存每个链表最小节点的集合中找到最小的节点
        ListNode minNode = list.get(0);
        int min = list.get(0).val;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < min) {
                min = list.get(i).val;
                minNode = list.get(i);
            }
        }
        return minNode;
    }
}
