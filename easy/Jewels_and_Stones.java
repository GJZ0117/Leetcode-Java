package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 */

public class Jewels_and_Stones {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                ans++;
            }
        }
        return ans;
    }
}
