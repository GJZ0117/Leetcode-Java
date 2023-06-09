package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 932. Beautiful Array
 */

public class Beautiful_Array {
    private Map<Integer, int[]> map = new HashMap<>();

    public int[] beautifulArray(int n) {
        int[] temp = map.get(n);
        if (temp != null) {
            return temp;
        }
        int[] res = new int[n];
        int i = 0;
        if (n != 1) {
            for (int num : beautifulArray((n + 1) / 2)) {
                res[i++] = 2 * num - 1;
            }
            for (int num : beautifulArray(n / 2)) {
                res[i++] = 2 * num;
            }
        } else {
            res[0] = 1;
        }
        map.put(n, res);
        return res;
    }
}
