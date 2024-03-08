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


    // 二刷
    public List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        Set<Character> needChar = new HashSet<>();

        for (char c : p.toCharArray()) {
            need[c - 'a']++;
            needChar.add(c);
        }

        int left = 0;
        int right = 0;

        while (right < p.length()) {
            char cur = s.charAt(right);
            window[cur - 'a']++;
            right++;
        }
        if (verify(needChar, need, window)) {
            list.add(left);
        }

        while (right < s.length()) {
            char c1 = s.charAt(right);
            char c2 = s.charAt(left);
            window[c1 - 'a']++;
            window[c2 - 'a']--;
            if (verify(needChar, need, window)) {
                list.add(left + 1);
            }
            right++;
            left++;
        }

        return list;
    }

    public boolean verify(Set<Character> needChar, int[] need, int[] window) {
        for (char c : needChar) {
            if (need[c - 'a'] != window[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
