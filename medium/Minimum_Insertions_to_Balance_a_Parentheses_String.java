package medium;

/**
 * 1541. Minimum Insertions to Balance a Parentheses String
 */

public class Minimum_Insertions_to_Balance_a_Parentheses_String {
    public int minInsertions(String s) {
        int n = s.length();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++;
                }
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
        }
        ans += left * 2;
        return ans;
    }
}
