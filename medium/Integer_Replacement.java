package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. Integer Replacement
 */

public class Integer_Replacement {

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        System.out.println(n);
        System.out.println(integerReplacement(n));
    }

    public static int integerReplacement(int n) {
        Map<Long, Integer> map = new HashMap<>();
        return dfs((long) n, map);
    }

    public static int dfs(Long n, Map<Long, Integer> map) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = n % 2 == 0 ? dfs(n / 2, map) : Math.min(dfs(n - 1, map), dfs(n + 1, map));
        map.put(n, ++ans);
        return ans;
    }
}
