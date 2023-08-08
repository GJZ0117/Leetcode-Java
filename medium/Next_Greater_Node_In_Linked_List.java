package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1019. Next Greater Node In Linked List
 */

public class Next_Greater_Node_In_Linked_List {
    int[] ans;
    Deque<Integer> stack = new ArrayDeque<>();

    public int[] nextLargerNodes(ListNode head) {
        f(head, 0);
        return ans;
    }

    public void f(ListNode node, int i) {
        if (node == null) {
            ans = new int[i];
            return;
        }
        f(node.next, i + 1);
        while (!stack.isEmpty() && stack.peek() <= node.val) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            ans[i] = stack.peek();
        }
        stack.push(node.val);
    }
}
