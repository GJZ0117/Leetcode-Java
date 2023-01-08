package medium;

/**
 * 467. Unique Substrings in Wraparound String
 */

public class Unique_Substrings_in_Wraparound_String {
    // https://leetcode.cn/problems/unique-substrings-in-wraparound-string/solution/by-fuxuemingzhu-ixas/
    public int findSubstringInWraproundString(String p) {
        char[] cs = p.toCharArray();
        int n = p.length();
        int[] dp = new int[26];
        dp[cs[0] - 'a'] = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if ((cs[i] - 'a') == (cs[i - 1] - 'a' + 1) % 26) {
                len++;
            } else {
                len = 1;
            }
            dp[cs[i] - 'a'] = Math.max(dp[cs[i] - 'a'], len);
        }

        int ans = 0;
        for (int num : dp) {
            ans += num;
        }
        return ans;
    }
}
