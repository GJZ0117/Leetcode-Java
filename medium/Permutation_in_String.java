package medium;

import java.util.HashMap;
import java.util.Map;

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
}
