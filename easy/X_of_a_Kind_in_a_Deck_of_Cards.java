package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 */

public class X_of_a_Kind_in_a_Deck_of_Cards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int minNum = Integer.MAX_VALUE;
        for (int num : map.values()) {
            minNum = Math.min(num, minNum);
        }

        for (int divisor = 2; divisor <= minNum; divisor++) {
            boolean flag = true;
            for (int num : map.values()) {
                if (num % divisor != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
