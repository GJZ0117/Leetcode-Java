package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 791. Custom Sort String
 */

public class Custom_Sort_String {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int value = map.get(c);
                while (value > 0) {
                    sb.append(c);
                    value--;
                }
                map.remove(c);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            while (value > 0) {
                sb.append(key);
                value--;
            }
        }
        return sb.toString();
    }
}
