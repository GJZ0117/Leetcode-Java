package easy;


import java.util.HashMap;
import java.util.Map;

/**
 * 389. Find the Difference
 */

public class Find_the_Difference {

    public char betterSolution(String s, String t) {
        int sSum = 0;
        int tSum = 0;
        for (int i = 0; i < s.length(); i++) {
            sSum += (s.charAt(i) - 'a');
            tSum += (t.charAt(i) - 'a');
        }
        tSum += (t.charAt(t.length() - 1) - 'a');
        return (char) ('a' + (tSum - sSum));
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();
        for (char c : s.toCharArray()) {
            map_s.put(c, map_s.containsKey(c) ? map_s.get(c) + 1 : 1);
        }
        for (char c : t.toCharArray()) {
            map_t.put(c, map_t.containsKey(c) ? map_t.get(c) + 1 : 1);
        }
        for (char c : map_t.keySet()) {
            if (!map_s.containsKey(c) || !map_t.get(c).equals(map_s.get(c))) {
                return c;
            }
        }
        return ' ';
    }
}
