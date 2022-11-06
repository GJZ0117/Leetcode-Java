package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 */

public class Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char curChar = pattern.charAt(i);
            if (!map.containsKey(curChar) && !map.containsValue(strs[i])) { // map does not contain key and value, add them
                map.put(curChar, strs[i]);
            } else if (map.containsKey(curChar)) { // map contains key
                if (!map.get(curChar).equals(strs[i])) { // if current word does not equal to key's value return false, else continue
                    return false;
                }
            } else if (map.containsValue(strs[i])) { // map contains current word but does not contains key, return false
                return false;
            }
        }
        return true;
    }
}
