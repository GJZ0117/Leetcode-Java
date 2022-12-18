package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 */

public class Longest_Harmonious_Subsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int len1 = map.get(num);
                int len2 = map.get(num + 1);
                maxLen = Math.max(maxLen, len1 + len2);
            }
        }
        return maxLen;
    }
}
