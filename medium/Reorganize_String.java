package medium;

/**
 * 767. Reorganize String
 */

public class Reorganize_String {
    public String reorganizeString(String s) {
        int[] charNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i) - 'a']++;
        }

        int maxNum = 0;
        char maxChar = ' ';
        for (int i = 0; i < 26; i++) {
            if (maxNum < charNum[i]) {
                maxNum = charNum[i];
                maxChar = (char) ('a' + i);
            }
            if (maxNum > (s.length() + 1) / 2) {
                return "";
            }
        }

        char[] ans = new char[s.length()];
        int index = 0;
        while (maxNum > 0) {
            ans[index] = maxChar;
            index += 2;
            maxNum--;
        }
        charNum[maxChar - 'a'] = 0;

        for (int i = 0; i < 26; i++) {
            int curNum = charNum[i];
            char curChar = (char) ('a' + i);
            while (curNum > 0) {
                if (index >= ans.length) {
                    index = 1;
                }
                ans[index] = curChar;
                index += 2;
                curNum--;
            }
        }
        return String.valueOf(ans);
    }
}
