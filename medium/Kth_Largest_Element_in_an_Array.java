package medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * 215. Kth Largest Element in an Array
 */

public class Kth_Largest_Element_in_an_Array {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        return heapSort(nums, k);
    }

    private static int heapSort(int[] arr, int k) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        int times = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            times++;
            if (times == k) {
                return arr[0];
            }
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        return arr[0];
    }


    private static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            if (temp >= arr[lChild]) {
                break;
            }
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }


    // 二刷
    public int findKthLargest_2(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        Map.Entry<Integer, Integer> entry = treeMap.lastEntry();
        while (!treeMap.isEmpty()) {
            entry = treeMap.lastEntry();
            treeMap.remove(entry.getKey());
            cnt += entry.getValue();
            if (cnt >= k) {
                return entry.getKey();
            }
        }
        return entry.getKey();
    }
}
