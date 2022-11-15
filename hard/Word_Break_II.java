package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 140. Word Break II
 */

public class Word_Break_II {

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] words = {"cats", "dog", "sand", "and", "cat"};
        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, words);
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new LinkedList<>();
        List<String> list = new LinkedList<>();
        dfs(ans, list, s, wordDict, 0);
        return ans;
    }

    public static void dfs(List<String> ans, List<String> list, String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(" ");
                }
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String tempStr = s.substring(start, i);
            if (wordDict.contains(tempStr)) {
                list.add(tempStr);
                dfs(ans, list, s, wordDict, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
