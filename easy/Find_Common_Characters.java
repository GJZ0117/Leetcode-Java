package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. Find Common Characters
 */

public class Find_Common_Characters {
    public List<String> commonChars(String[] words) {
        int[] chars = new int[26];
        int[] temp = new int[26];
        for (char c : words[0].toCharArray()) {
            chars[c - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (temp[j] < chars[j]) {
                    chars[j] = temp[j];
                }
            }
            Arrays.fill(temp, 0);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (chars[i] != 0) {
                list.add(String.valueOf((char) ('a' + i)));
                chars[i]--;
            }
        }
        return list;
    }
}
