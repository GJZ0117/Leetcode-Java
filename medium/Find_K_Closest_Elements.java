package medium;

import java.util.*;

/**
 * 658. Find K Closest Elements
 */

public class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int num : arr) {
            int diff = Math.abs(x - num);
            if (map.containsKey(diff)) {
                map.get(diff).add(num);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(diff, list);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (res.size() + list.size() < k) {
                res.addAll(list);
            } else {
                for (int i = 0; i < list.size() && res.size() < k; i++) {
                    res.add(list.get(i));
                }
            }
        }
        Collections.sort(res);
        return res;
    }


    // 二刷
    public List<Integer> findClosestElements_2(int[] arr, int k, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int j : arr) {
            int diff = Math.abs(j - x);
            if (map.containsKey(diff)) {
                map.get(diff).add(j);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(j);
                map.put(diff, list);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (k > 0) {
            List<Integer> list = map.firstEntry().getValue();
            for (int i = 0; i < list.size() && k > 0; i++, k--) {
                ans.add(list.get(i));
            }
            map.remove(map.firstKey());
        }
        Collections.sort(ans);
        return ans;
    }
}
