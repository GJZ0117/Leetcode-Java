package easy;

import java.util.PriorityQueue;

/**
 * 1005. Maximize Sum Of Array After K Negations
 */

public class Maximize_Sum_Of_Array_After_K_Negations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Math.min(k, nums.length), (i1, i2) -> (i1 - i2));
        int sum = 0;
        for (int n : nums) {
            sum = sum + n;
            minHeap.offer(n);
        }
        while (k > 0 && !minHeap.isEmpty()) {
            int minNum = minHeap.poll();
            if (minNum < 0) {
                k--;
                sum = sum + (-2) * minNum;
            } else {
                if (k > 1) {
                    k = k % 2;
                }
                sum = sum + (-2) * k * minNum;
                k--;
            }
            minHeap.offer(-minNum);
        }
        return sum;
    }
}
