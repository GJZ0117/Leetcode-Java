package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 697. Degree of an Array
 */

public class Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxValue = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                list.clear();
                list.add(key);
            } else if (value == maxValue) {
                list.add(key);
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (int key : list) {
            boolean findFirst = false;
            int value = map.get(key);
            int curLen = 0;
            for (int i = 0; value > 0 && i < nums.length; i++) {
                if (findFirst) {
                    if (nums[i] == key) {
                        value--;
                    }
                    curLen++;
                } else {
                    findFirst = (nums[i] == key);
                    if (findFirst) {
                        value--;
                        curLen++;
                    }
                }
            }

            minLen = Math.min(minLen, curLen);
        }
        return minLen;
    }
}
