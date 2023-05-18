package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. Groups of Special-Equivalent Strings
 */

public class Groups_of_Special_Equivalent_Strings {
    public int numSpecialEquivGroups(String[] words) {
        int[] flag = new int[52];
        String str;
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    flag[26 + word.charAt(i) - 'a']++;
                } else {
                    flag[word.charAt(i) - 'a']++;
                }
            }
            str = Arrays.toString(flag);
            if (!set.contains(str)) {
                ans++;
                set.add(str);
            }
            Arrays.fill(flag, 0);
        }
        return ans;
    }
}
