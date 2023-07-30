package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 */

public class Minimum_Domino_Rotations_For_Equal_Row {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int len = tops.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tops) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : bottoms) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value >= len) {
                boolean flag = true;
                int upToDownCount = 0;
                int downToUpCount = 0;
                for (int i = 0; i < len; i++) {
                    if (tops[i] == key || bottoms[i] == key) {
                        if (tops[i] == key && bottoms[i] == key) {
                            continue;
                        } else if (tops[i] == key) {
                            upToDownCount++;
                        } else {
                            downToUpCount++;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return Math.min(upToDownCount, downToUpCount);
                }
            }
        }
        return -1;
    }
}
