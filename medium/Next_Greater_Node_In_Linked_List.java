package medium;

import java.util.*;

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


    // 二刷
    public int[] nextLargerNodes_2(ListNode head) {
        int len = 0;
        ListNode node = head;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while (node != null) {
            map.put(index++, node.val);
            len++;
            node = node.next;
        }

        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<>();

        node = head;
        index = 0;
        while (node != null) {
            while (!stack.isEmpty() && node.val > map.get(stack.peekLast())) {
                int top = stack.pollLast();
                ans[top] = node.val;
            }
            stack.addLast(index++);
            node = node.next;
        }
        return ans;
    }
}
