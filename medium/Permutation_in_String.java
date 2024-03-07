package medium;

import java.util.*;

/**
 * 567. Permutation in String
 */

public class Permutation_in_String {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char curChar;
        char delChar;

        for (int i = 0; i < s1.length(); i++) {
            curChar = s1.charAt(i);
            map1.put(curChar, map1.containsKey(curChar) ? map1.get(curChar) + 1 : 1);
        }

        int i;
        for (i = 0; i < s1.length() - 1; i++) {
            curChar = s2.charAt(i);
            window.put(curChar, window.containsKey(curChar) ? window.get(curChar) + 1 : 1);
        }
        for (; i < s2.length(); i++) {
            curChar = s2.charAt(i);
            window.put(curChar, window.containsKey(curChar) ? window.get(curChar) + 1 : 1);
            if (check(map1, window)) {
                return true;
            }
            delChar = s2.charAt(i - s1.length() + 1);
            window.put(delChar, window.get(delChar) - 1);
            if (window.get(delChar).equals(0)) {
                window.remove(delChar);
            }
        }
        return false;
    }

    public static boolean check(Map<Character, Integer> map1, Map<Character, Integer> window) {
        if (map1.keySet().size() != window.keySet().size()) {
            return false;
        }
        for (Character ch : map1.keySet()) {
            if (!map1.get(ch).equals(window.get(ch))) {
                return false;
            }
        }
        return true;
    }


    // 二刷
    public boolean checkInclusion_2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        Set<Character> needChar = new HashSet<>();
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
            needChar.add(c);
        }

        int left = 0;
        int right = 0;

        while (right < s1.length()) {
            char c = s2.charAt(right);
            window[c - 'a']++;
            right++;
        }
        if (verify(needChar, need, window)) {
            return true;
        }

        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            char c2 = s2.charAt(left);
            window[c1 - 'a']++;
            window[c2 - 'a']--;
            if (verify(needChar, need, window)) {
                return true;
            }
            left++;
            right++;
        }

        return false;
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
