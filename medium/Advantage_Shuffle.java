package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 870. Advantage Shuffle
 */

public class Advantage_Shuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.sort(nums1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> nums2[b] - nums2[a]);
        for (int i = 0; i < nums2.length; i++) {
            heap.offer(i);
        }
        int i = 0;
        int j = nums1.length - 1;
        while (!heap.isEmpty()) {
            int index = heap.poll();
            if (nums1[j] > nums2[index]) {
                ans[index] = nums1[j];
                j--;
            } else {
                ans[index] = nums1[i];
                i++;
            }
        }
        return ans;
    }
}
