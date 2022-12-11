package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    //https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) < k) {
                int res = 0;
                for (String str : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
