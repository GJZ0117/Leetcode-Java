package medium;

import java.util.*;

/**
 * 916. Word Subsets
 */

public class Word_Subsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] word2Map = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for (String word2 : words2) {
            for (char c : word2.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                word2Map[entry.getKey() - 'a'] = Math.max(word2Map[entry.getKey() - 'a'], entry.getValue());
            }
            map.clear();
        }
        int[] word1Map = new int[26];
        for (String word1 : words1) {
            boolean flag = true;
            for (char c : word1.toCharArray()) {
                word1Map[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (word1Map[i] < word2Map[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word1);
            }
            Arrays.fill(word1Map, 0);
        }
        return list;
    }
}
