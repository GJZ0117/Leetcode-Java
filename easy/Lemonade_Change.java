package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 860. Lemonade Change
 */

public class Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                if (map.containsKey(5) && map.get(5) > 0) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.getOrDefault(10, 0) + 1);
                } else {
                    return false;
                }
            } else if (bill == 20) {
                int remain = 15;
                if (map.containsKey(10) && map.get(10) > 0) {
                    map.put(10, map.get(10) - 1);
                    remain -= 10;
                }
                while (map.containsKey(5) && map.get(5) > 0 && remain > 0) {
                    map.put(5, map.get(5) - 1);
                    remain -= 5;
                }
                if (remain > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
