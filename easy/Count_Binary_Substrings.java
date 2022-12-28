package easy;

/**
 * 696. Count Binary Substrings
 */

public class Count_Binary_Substrings {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                int len = 1;
                while (i - len >= 0 && i + len - 1 < s.length()) {
                    if (s.charAt(i - len) == s.charAt(i - 1) && s.charAt(i + len - 1) == s.charAt(i)) {
                        ans++;
                    } else {
                        break;
                    }
                    len++;
                }
            }
        }
        return ans;
    }
}
