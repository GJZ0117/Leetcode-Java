package medium;

/**
 * 1367. Linked List in Binary Tree
 */

public class Linked_List_in_Binary_Tree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return preOrder(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }


    public boolean preOrder(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        boolean left = preOrder(root.left, head.next);
        boolean right = preOrder(root.right, head.next);
        return left || right;
    }
}
