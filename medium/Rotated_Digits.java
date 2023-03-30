package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 788. Rotated Digits
 */

public class Rotated_Digits {
    public int rotatedDigits(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(9, 6);
        Map<Integer, Integer> memo = new HashMap<>();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int convertNum = convert(i, map, memo);
            memo.put(i, convertNum);
            if (convertNum != -1 && convertNum != i) {
                ans++;
            }
        }
        return ans;
    }

    private int convert(int num, Map<Integer, Integer> map, Map<Integer, Integer> memo) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (memo.containsKey(num)) {
                int n = memo.get(num);
                if (n != -1) {
                    sb.insert(0, memo.get(num));
                    return Integer.parseInt(sb.toString());
                } else {
                    return -1;
                }
            }
            int n = num % 10;
            if (map.containsKey(n)) {
                sb.insert(0, map.get(n));
            } else {
                return -1;
            }
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
