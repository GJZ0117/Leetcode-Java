package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, ans, list, 0);
        return ans;
    }

    public static void dfs(String s, List<List<String>> ans, List<String> list, int left) {
        if (left == s.length()) {
            List<String> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        for (int right = left; right < s.length(); right++) {
            if (isPalindrome(s, left, right)) {
                list.add(s.substring(left, right + 1));
                dfs(s, ans, list, right + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
