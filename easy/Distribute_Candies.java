package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies
 */

public class Distribute_Candies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        int halfNum = candyType.length / 2;
        int maxTypeNums = 0;
        for (int i = 0; i < set.size(); i++) {
            maxTypeNums++;
            halfNum--;
            if (halfNum == 0) {
                break;
            }
        }
        return maxTypeNums;
    }
}
