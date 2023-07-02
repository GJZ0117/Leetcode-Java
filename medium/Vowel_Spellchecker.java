package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 966. Vowel Spellchecker
 */

public class Vowel_Spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (String word : wordlist) {
            set.add(word);
            if (!map1.containsKey(word.toLowerCase())) {
                map1.put(word.toLowerCase(), word);
            }
            String newWord = word.toLowerCase().replace('a', '0').replace('e', '0').replace('i', '0').replace('o', '0').replace('u', '0');
            if (!map2.containsKey(newWord)) {
                map2.put(newWord, word);
            }
        }

        String[] ans = new String[queries.length];
        int index = 0;
        for (String query : queries) {
            if (set.contains(query)) {
                ans[index++] = query;
            } else if (map1.containsKey(query.toLowerCase())) {
                ans[index++] = map1.get(query.toLowerCase());
            } else {
                String newWord = query.toLowerCase().replace('a', '0').replace('e', '0').replace('i', '0').replace('o', '0').replace('u', '0');
                ans[index++] = map2.getOrDefault(newWord, "");
            }
        }
        return ans;
    }
}
