package medium;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 */

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new LinkedList<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            list.add(temp);
        }
        list.sort(Comparator.comparingInt(a -> a.get(1)));
        int resIndex = 0;
        int listIndex = list.size() - 1;
        while (k > 0) {
            res[resIndex++] = list.get(listIndex--).get(0);
            k--;
        }
        return res;
    }


    // 二刷
    public int[] topKFrequent_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        int index = 0;
        while (k > 0 && !heap.isEmpty()) {
            int[] arr = heap.poll();
            res[index++] = arr[0];
            k--;
        }
        return res;
    }
}
