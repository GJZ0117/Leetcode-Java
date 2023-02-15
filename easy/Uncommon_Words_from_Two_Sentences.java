package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. Uncommon Words from Two Sentences
 */

public class Uncommon_Words_from_Two_Sentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] str1s = s1.split(" ");
        String[] str2s = s2.split(" ");
        for (String word : str1s) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : str2s) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String word = entry.getKey();
            Integer num = entry.getValue();
            if (!map2.containsKey(word) && num == 1) {
                list.add(word);
            }
        }
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String word = entry.getKey();
            Integer num = entry.getValue();
            if (!map1.containsKey(word) && num == 1) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
