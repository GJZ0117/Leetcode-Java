package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. Validate Stack Sequences
 */

public class Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int pushedIndex = 0;
        int poppedIndex = 0;
        deque.add(pushed[pushedIndex++]);
        while (pushedIndex < pushed.length) {
            while (!deque.isEmpty() && deque.peekLast() == popped[poppedIndex]) {
                deque.pollLast();
                poppedIndex++;
            }
            deque.add(pushed[pushedIndex++]);
        }
        while (!deque.isEmpty() && poppedIndex < popped.length) {
            if (deque.peekLast() == popped[poppedIndex]) {
                deque.pollLast();
                poppedIndex++;
            } else {
                break;
            }
        }
        return deque.isEmpty();
    }
}
