package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 */

public class Valid_Anagram {

    public boolean betterSolution(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.containsKey(c) ? mapS.get(c) + 1 : 1);
        }
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.containsKey(c) ? mapT.get(c) + 1 : 1);
        }

        for (char c : mapT.keySet()) {
            if (!mapS.containsKey(c) || !mapS.get(c).equals(mapT.get(c))) {
                return false;
            }
        }
        return true;
    }
}
