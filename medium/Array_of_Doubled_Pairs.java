package medium;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 954. Array of Doubled Pairs
 */

public class Array_of_Doubled_Pairs {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : arr) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        Arrays.fill(arr, Integer.MIN_VALUE);
        int n1;
        int n2;
        for (int i = 0; i < arr.length / 2; i++) {

            n1 = treeMap.firstKey();

            if (n1 < 0 && Math.abs(n1) % 2 == 1) {
                return false;
            }

            if (treeMap.get(n1) == 1) {
                treeMap.remove(n1);
            } else {
                treeMap.put(n1, treeMap.get(n1) - 1);
            }

            if (n1 < 0 && treeMap.containsKey(n1 / 2)) {
                n2 = n1 / 2;
                arr[2 * i] = n2;
                arr[2 * i + 1] = n1;
            } else if (n1 >= 0 && treeMap.containsKey(n1 * 2)) {
                n2 = n1 * 2;
                arr[2 * i] = n1;
                arr[2 * i + 1] = n2;
            } else {
                return false;
            }

            if (treeMap.containsKey(n2) && treeMap.get(n2) == 1) {
                treeMap.remove(n2);
            } else if (treeMap.containsKey(n2) && treeMap.get(n2) > 1) {
                treeMap.put(n2, treeMap.get(n2) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
