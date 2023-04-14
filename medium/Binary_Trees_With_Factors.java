package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823. Binary Trees With Factors
 */

public class Binary_Trees_With_Factors {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        int len = arr.length;

        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, 1L);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int result = arr[i] / arr[j];
                    if (map.containsKey(result)) {
                        long count = (map.get(arr[i]) + map.get(arr[j]) * map.get(result)) % mod;
                        map.put(arr[i], count);
                    }
                }
            }
        }

        long ans = 0;
        for (long c : map.values()) {
            ans += c;
        }
        return (int) ans % mod;
    }
}
