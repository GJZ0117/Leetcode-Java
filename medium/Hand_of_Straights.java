package medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * 846. Hand of Straights
 */

public class Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        while (map.size() > 0) {
            Map.Entry<Integer, Integer> startEntry = map.firstEntry();
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(startEntry.getKey() + i)) {
                    return false;
                }
                if (map.get(startEntry.getKey() + i) == 1) {
                    map.remove(startEntry.getKey() + i);
                } else {
                    map.put(startEntry.getKey() + i, map.get(startEntry.getKey() + i) - 1);
                }
            }
        }
        return true;
    }
}
