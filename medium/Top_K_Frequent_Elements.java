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
}
