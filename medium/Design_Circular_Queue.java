package medium;

/**
 * 622. Design Circular Queue
 */

public class Design_Circular_Queue {
    class MyCircularQueue {

        int[] queue;
        int maxSize;
        int front = 0;
        int rear = 0;

        public MyCircularQueue(int k) {
            queue = new int[k + 1];
            maxSize = k + 1;
        }

        public boolean enQueue(int value) {
            if ((rear + 1) % maxSize == front) {
                return false;
            }
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (front == rear) {
                return false;
            }
            front = (front + 1) % maxSize;
            return true;
        }

        public int Front() {
            if (front == rear) {
                return -1;
            }
            return queue[(front + 1) % maxSize];
        }

        public int Rear() {
            if (front == rear) {
                return -1;
            }
            return queue[rear % maxSize];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }
    }
}
