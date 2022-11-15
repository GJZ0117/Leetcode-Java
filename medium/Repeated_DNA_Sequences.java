package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
}
