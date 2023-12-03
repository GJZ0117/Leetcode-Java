package medium;

/**
 * 237. Delete Node in a Linked List
 */

public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    // 二刷
    public void deleteNode_2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
