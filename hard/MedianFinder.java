package hard;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // the left side of the array needs a max heap
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // the right side of the array needs a min heap
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        // if the min heap does not contain number or the coming number is bigger than the smallest number in min heap, add it into min heap
        if (minHeap.size() == 0 || minHeap.peek() <= num) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        // if two heaps' sizes' difference is over 1, modify them
        if (minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}
