package medium;

import java.util.*;

/**
 * 187. Repeated DNA Sequences
 */

public class Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        String tempStr;
        for (int i = 0; i + 10 <= s.length(); i++) {
            tempStr = s.substring(i, i + 10);
            map.put(tempStr, map.containsKey(tempStr) ? map.get(tempStr) + 1 : 1);
        }
        for (String str : map.keySet()) {
            if (map.get(str) > 1) {
                ans.add(str);
            }
        }
        return ans;
    }


    // 二刷
    public List<String> findRepeatedDnaSequences_2(String s) {
        Set<String> dictinctSet = new HashSet<>();
        Set<String> repeatSet = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (dictinctSet.contains(str)) {
                repeatSet.add(str);
            } else {
                dictinctSet.add(str);
            }
        }
        return new ArrayList<>(repeatSet);
    }
}
