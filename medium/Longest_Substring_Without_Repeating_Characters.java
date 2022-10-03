package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 */

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        String s = "pwwkew";
//        String s = "cdd";
        System.out.println(lengthOfLongestSubstring(s));
    }


    //超时
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = s.length();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i <= s.length() - maxLen; i++) {
            arrayList.clear();
            for (int j = i; j < i + maxLen; j++) {
                if (arrayList.contains(s.charAt(j))) { //list中已存在相同的字符
                    break;
                } else { //list中不存在该字符则将该字符填入list中
                    arrayList.add(s.charAt(j));
                }
            }

            if (maxLen == arrayList.size()) { //找到最长无重复子串
                break;
            }

            if (i == (s.length() - maxLen)) { //该最大长度下找到最后一组仍不存在无重复的子串，i归零最大长度减一
                i = -1;
                maxLen--;
            }
        }
        return maxLen;
    }


    public static int lengthOfLongestSubstringBetterSolution(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        //HashMap用于记录字符和其对应的索引
        HashMap<Character, Integer> map = new HashMap<>();
        //用i从左往右遍历字符串，若遍历的字符已存在于map中，则移动指针j到当前已遍历过字符串中最右边的相同字符，最大长度为两指针位置之差+1
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
