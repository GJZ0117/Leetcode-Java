package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 */

public class Implement_Stack_using_Queues {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
