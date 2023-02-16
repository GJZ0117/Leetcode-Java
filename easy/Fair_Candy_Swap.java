package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 888. Fair Candy Swap
 */

public class Fair_Candy_Swap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int bobSum = 0;
        int aliceSum = 0;
        Set<Integer> aliceSet = new HashSet<>();
        for (int n : aliceSizes) {
            aliceSet.add(n);
            aliceSum += n;
        }
        for (int n : bobSizes) {
            bobSum += n;
        }
        int diff = aliceSum - bobSum;
        int[] res = new int[2];

        for (int n : bobSizes) {
            if (aliceSet.contains(n + diff / 2) && (bobSum + diff / 2 == aliceSum - (diff - diff / 2))) {
                res[0] = n + diff / 2;
                res[1] = n;
                break;
            }
        }
        return res;
    }
}
