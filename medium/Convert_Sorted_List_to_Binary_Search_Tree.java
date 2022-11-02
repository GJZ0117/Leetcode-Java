package medium;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */

public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return generate(head, null);
    }

    public TreeNode generate(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = generate(head, slow);
        root.right = generate(slow.next, tail);
        return root;
    }
}
