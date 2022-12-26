package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 */

public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            char c = entry.getKey();
            int num = entry.getValue();
            while (num > 0) {
                sb.append(c);
                num--;
            }
        }
        return sb.toString();
    }
}
