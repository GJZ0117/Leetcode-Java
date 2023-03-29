package medium;

import java.util.*;

/**
 * 786. K-th Smallest Prime Fraction
 */

public class Kth_Smallest_Prime_Fraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        Map<Double, int[]> map = new HashMap<>(n * (n - 1) / 2);
        List<Double> list = new ArrayList<>(n * (n - 1) / 2);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double key = (double) arr[i] / (double) arr[j];
                int[] pos = new int[]{i, j};
                map.put(key, pos);
                list.add(key);
            }
        }
        Collections.sort(list);
        Double key = list.get(k - 1);
        int[] pos = map.get(key);
        return new int[]{arr[pos[0]], arr[pos[1]]};
    }
}
