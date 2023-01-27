package easy;

import java.util.Arrays;

/**
 * 821. Shortest Distance to a Character
 */

public class Shortest_Distance_to_a_Character {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        Arrays.fill(ans, s.length() + 1);
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                index = i;
            }
            if (index != -1) {
                ans[i] = i - index;
            }
        }

        index = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }
            if (index != -1) {
                ans[i] = Math.min(ans[i], index - i);
            }
        }

        return ans;
    }
}
