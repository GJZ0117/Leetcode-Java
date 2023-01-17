package medium;

import java.util.Arrays;

/**
 * 522. Longest Uncommon Subsequence II
 */

public class Longest_Uncommon_Subsequence_II {

    public static void main(String[] args) {
        String[] strs = {"abcabc","abcabc","abcabc","abc","abc","cca"};
        System.out.println(findLUSlength(strs));
    }

    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        int left = 0;
        while (left < strs.length) {
            int curStrLen = strs[left].length();
            int right = left + 1;
            while (right < strs.length && strs[right].length() == curStrLen) {
                right++;
            }

            for (int i = left; i < right; i++) {
                boolean isSubStr = false;
                String curStr = strs[i];
                for (int j = 0; j < right; j++) {
                    if (i != j && isSubStr(curStr, strs[j])) {
                        isSubStr = true;
                        break;
                    }
                }
                if (!isSubStr) {
                    return curStr.length();
                }
            }
            left = right;
        }

        return -1;
    }

    public static boolean isSubStr(String curStr, String str) {
        int i = 0;
        int j = 0;
        while (i < curStr.length() && j < str.length()) {
            while (j < str.length() && str.charAt(j) != curStr.charAt(i)) {
                j++;
            }
            if (j < str.length() && str.charAt(j) == curStr.charAt(i)) {
                i++;
                j++;
            } else {
                break;
            }
        }

        return i == curStr.length();
    }
}
