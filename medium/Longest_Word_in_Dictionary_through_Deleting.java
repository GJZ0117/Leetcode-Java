package medium;

import java.util.Collections;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 */

public class Longest_Word_in_Dictionary_through_Deleting {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b) -> b.length() - a.length());
        String longestWord = "";
        for (String word : dictionary) {
            if (longestWord.length() > 0 && word.length() < longestWord.length()) {
                break;
            }
            if (isSubStr(s, word)) {
                if (longestWord.length() == 0) {
                    longestWord = word;
                } else if (longestWord.length() == word.length() && compareLexicographicalOrder(longestWord, word) == 1) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

    public boolean isSubStr(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            while (i < s.length() && s.charAt(i) != word.charAt(j)) {
                i++;
            }
            if (i < s.length() && s.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        return j == word.length();
    }

    public int compareLexicographicalOrder(String longestWord, String word) {
        for (int i = 0; i < word.length(); i++) {
            int diff = longestWord.charAt(i) - word.charAt(i);
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return 0;
            }
        }
        return 0; // longestword == word
    }
}
