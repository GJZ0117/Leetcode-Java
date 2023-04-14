package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. Card Flipping Game
 */

public class Card_Flipping_Game {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int num : fronts) {
            if (!set.contains(num)) {
                ans = Math.min(ans, num);
            }
        }
        for (int num : backs) {
            if (!set.contains(num)) {
                ans = Math.min(ans, num);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
