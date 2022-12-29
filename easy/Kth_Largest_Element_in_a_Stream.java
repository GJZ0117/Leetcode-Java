package easy;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 */

public class Kth_Largest_Element_in_a_Stream {
    class KthLargest {
        private PriorityQueue<Integer> heap;
        private int size;

        public KthLargest(int k, int[] nums) {
            heap = new PriorityQueue<>(k);
            size = k;
            for (int num : nums) {
                heap.offer(num);
            }
        }

        public int add(int val) {
            if (heap.size() < size) {
                heap.offer(val);
            } else if (heap.peek() < val) {
                heap.poll();
                heap.offer(val);
            }
            System.out.println(val +" : " + heap);
            return heap.peek();
        }
    }
}
