package medium;

import java.util.*;

/**
 * 890. Find and Replace Pattern
 */

public class Find_and_Replace_Pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        char[] map = new char[26];
        boolean[] used = new boolean[26];
        Arrays.fill(map, '0');
        boolean flag;
        for (String word : words) {
            flag = true;
            for (int i = 0; i < pattern.length(); i++) {
                int pIndex = pattern.charAt(i) - 'a';
                int wIndex = word.charAt(i) - 'a';
                if (map[pIndex] == '0' && !used[wIndex]) {
                    map[pIndex] = word.charAt(i);
                    used[wIndex] = true;
                } else if (map[pIndex] == word.charAt(i)) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
            Arrays.fill(map, '0');
            Arrays.fill(used, false);
        }
        return list;
    }
}
