package easy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 */

public class Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = 0;
        int ans = 0;
        for (int gIndex = 0; gIndex < g.length; gIndex++) {
            while (sIndex < s.length && s[sIndex] < g[gIndex]) {
                sIndex++;
            }
            if (sIndex == s.length) {
                break;
            } else if (s[sIndex] >= g[gIndex]) {
                ans++;
                sIndex++;
            }
        }
        return ans;
    }
}
