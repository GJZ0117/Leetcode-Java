package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 720. Longest Word in Dictionary
 */

public class Longest_Word_in_Dictionary {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : set) {
            int m = s.length();
            int n = ans.length();
            if (m < n || (n == m && s.compareTo(ans) > 0)) {
                continue;
            }
            boolean flag = true;
            for (int i = 1; i <= m && flag; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) {
                    flag = false;
                }
            }
            if (flag) {
                ans = s;
            }
        }
        return ans;
    }
}
