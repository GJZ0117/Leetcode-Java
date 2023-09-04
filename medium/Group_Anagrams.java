package medium;

import java.util.*;

/**
 * 49. Group Anagrams
 */

public class Group_Anagrams {

    /**
     * 对每个字符串中的所有字符按字典序进行排列生成一个排序数组，通过该数组生成一个字符串，以生成的字符串为key、相同字符单词组成的list为value，装入map中
     * 如果map中有该排序过的字符串的key，则将当前遍历到的字符填入对应的value的列表中；若map中不存在该key，则在map中填入该键值对
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(); //key为对每个字符串中字符经过排序后
        char[] arrayChar;
        for (String str : strs) {
            arrayChar = str.toCharArray();
            Arrays.sort(arrayChar);
            String sortedStr = new String(arrayChar);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }

        for (String sortedStr : map.keySet()) {
            ans.add(map.get(sortedStr));
        }
        return ans;
    }


    // 二刷
    public List<List<String>> groupAnagrams_2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (chars[i] != 0) {
                    sb.append(chars[i]);
                    sb.append((char) ('a' + i));
                    chars[i] = 0;
                }
            }
            String key = sb.toString();
            sb.delete(0, sb.length());
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
