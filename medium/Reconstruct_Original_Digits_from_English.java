package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 423. Reconstruct Original Digits from English
 */

public class Reconstruct_Original_Digits_from_English {
    /**
     * z,w,u,x,g only showes in 0,2,4,6,8
     * h only showes in 3,8; f only showes in 4,5; s only showes in 6,7
     * o only showes in 0,1,2,4; use i to count 9
     */
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int[] count = new int[10];

        count[0] = map.getOrDefault('z', 0);
        count[2] = map.getOrDefault('w', 0);
        count[4] = map.getOrDefault('u', 0);
        count[6] = map.getOrDefault('x', 0);
        count[8] = map.getOrDefault('g', 0);

        count[3] = map.getOrDefault('h', 0) - count[8];
        count[5] = map.getOrDefault('f', 0) - count[4];
        count[7] = map.getOrDefault('s', 0) - count[6];

        count[1] = map.getOrDefault('o', 0) - count[0] - count[2] - count[4];
        count[9] = map.getOrDefault('i', 0) - count[5] - count[6] - count[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
