package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 */

public class Minimum_Index_Sum_of_Two_Lists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index1 = map.get(list2[i]);
                if (index1 + i == minIndexSum) {
                    list.add(list2[i]);
                } else if (index1 + i < minIndexSum) {
                    minIndexSum = index1 + i;
                    list.clear();
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
