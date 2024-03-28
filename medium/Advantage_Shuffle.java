package medium;

import java.util.Arrays;
import java.util.Comparator;
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


    // 二刷
    public int[] advantageCount_2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        while (!maxHeap.isEmpty()) {
            int[] pair = maxHeap.poll();
            int idx = pair[0];
            int maxValue = pair[1];
            if (maxValue < nums1[right]) {
                ans[idx] = nums1[right];
                right--;
            } else {
                ans[idx] = nums1[left];
                left++;
            }
        }
        return ans;
    }
}
