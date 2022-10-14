package medium;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 */

public class Find_All_Anagrams_in_a_String {

    public static void main(String[] args) {
        System.out.println(findAnagrams("baa", "aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (Character c : p.toCharArray()) {
            need.put(c, need.containsKey(c) ? need.get(c) + 1 : 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.containsKey(c) ? window.get(c) + 1 : 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while ((right - left) >= p.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    list.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return list;
    }
}
