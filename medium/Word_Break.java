package medium;

import java.util.List;

/**
 * 139. Word Break
 */

public class Word_Break {

    public boolean betterSolution(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    //the answer is right but time limited exceeded
    public boolean wordBreak(String s, List<String> wordDict) {
        return findWords(s, wordDict, 0);
    }

    public static boolean match(String s, int start, String word) {
        if (s.length() < start + word.length()) { //if s length is shorter than start position + word's length, it proves that word is not matched
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(start + i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean findWords(String s, List<String> wordDict, int start) {
        for (String word : wordDict) {
            if (word.charAt(0) == s.charAt(start)) { //word's first character equals to current position's character, check if it matches
                if (match(s, start, word)) {
                    if (word.length() + start == s.length()) {
                        return true;
                    }
                    if (findWords(s, wordDict, start + word.length())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // 二刷（还不会）
    public boolean wordBreak_2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i - word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[n];
    }
}
