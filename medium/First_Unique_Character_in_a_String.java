package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 */

public class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
