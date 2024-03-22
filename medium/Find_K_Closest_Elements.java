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


    // 三刷
    public List<Integer> findClosestElements_3(int[] arr, int k, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int n : arr) {
            int key = Math.abs(n - x);
            if (map.containsKey(key)) {
                map.get(key).add(n);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                map.put(key, list);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (k > 0) {
            Map.Entry<Integer, List<Integer>> entry = map.firstEntry();
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            map.remove(key);
            for (int i = 0; i < list.size() && k > 0; i++) {
                ans.add(list.get(i));
                k--;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
