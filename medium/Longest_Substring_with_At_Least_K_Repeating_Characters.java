package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    // https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) < k) {
                int res = 0;
                for (String str : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }
        return s.length();
    }


    // 二刷（还不会）
    public int longestSubstring_2(String s, int k) {
        // 字符串s长度小于k，一定不存在满足题意的子字符串，返回0
        if (s.length() < k) {
            return 0;
        }
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : s.toCharArray()) {
            // 如果一个字符c在s中出现的次数少于k次，那么s中所有的包含c的子字符串都不能满足题意，所以应该在s的所有不包含c的子字符串中继续寻找结果
            if (counter.get(c) < k) {
                int res = 0;
                // 把s按照c分割（分割后每个子串都不包含c），得到很多子字符串str
                for (String str : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring_2(str, k));
                }
                return res;
            }
        }
        // 如果s中的每个字符出现的次数都大于k次，那么s就是要求的字符串，直接返回该字符串的长度
        return s.length();
    }


    // 三刷 双指针
    // https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solutions/624045/xiang-jie-mei-ju-shuang-zhi-zhen-jie-fa-50ri1/?show=1
    public int longestSubstring_3(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int x = 1; x <= 26; x++) {
            Arrays.fill(count, 0);
            for (int i = 0, j = 0, charCount = 0, sum = 0; i < n; i++) {
                int right = chars[i] - 'a';
                count[right]++;
                if (count[right] == 1) {
                    charCount++;
                }
                if (count[right] == k) {
                    sum++;
                }

                while (charCount > x) {
                    int left = chars[j] - 'a';
                    j++;
                    count[left]--;
                    if(count[left] == 0) {
                        charCount--;
                    }
                    if (count[left] == k - 1) {
                        sum--;
                    }
                }

                if (charCount == sum) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }

        return ans;
    }
}
