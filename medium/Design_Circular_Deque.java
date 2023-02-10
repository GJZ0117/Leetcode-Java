package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 641. Design Circular Deque
 */

public class Design_Circular_Deque {
    class MyCircularDeque {

        Deque<Integer> deque;
        int maxSize;

        public MyCircularDeque(int k) {
            deque = new ArrayDeque<>();
            maxSize = k;
        }

        public boolean insertFront(int value) {
            if (deque.size() == maxSize) {
                return false;
            }
            deque.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (deque.size() == maxSize) {
                return false;
            }
            deque.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (deque.size() == 0) {
                return false;
            }
            deque.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if (deque.size() == 0) {
                return false;
            }
            deque.pollLast();
            return true;
        }

        public int getFront() {
            if (deque.size() == 0) {
                return -1;
            }
            return deque.peekFirst();
        }

        public int getRear() {
            if (deque.size() == 0) {
                return -1;
            }
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return deque.size() == 0;
        }

        public boolean isFull() {
            return deque.size() == maxSize;
        }
    }
}
