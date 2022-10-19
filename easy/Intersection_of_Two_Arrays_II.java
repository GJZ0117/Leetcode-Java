package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 */

public class Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            map1.put(num, map1.containsKey(num) ? map1.get(num) + 1 : 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.containsKey(num) ? map2.get(num) + 1 : 1);
        }

        if (map1.keySet().size() > map2.keySet().size()) { // keep map1's length shorter than map2's length, which can make program more efficient
            Map<Integer, Integer> temp;
            temp = map1;
            map1 = map2;
            map2 = temp;
        }

        for (int n1 : map1.keySet()) {
            if (map2.containsKey(n1)) {
                int times = Math.min(map1.get(n1), map2.get(n1));
                while (times > 0) {
                    list.add(n1);
                    times--;
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
