package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 748. Shortest Completing Word
 */

public class Shortest_Completing_Word {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        licensePlate = licensePlate.toLowerCase();
        map = fillMap(licensePlate, map);

        String ans = words[0];
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> temp = new HashMap<>();
        for (String word : words) {
            temp = fillMap(word, temp);
            boolean isMatch = true;
            for (Character c : map.keySet()) {
                if (!temp.containsKey(c) || temp.get(c) < map.get(c)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch && word.length() < minLen) {
                ans = word;
                minLen = word.length();
            }

            temp.clear();
        }
        return ans;
    }

    public Map<Character, Integer> fillMap(String s, Map<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }
}
