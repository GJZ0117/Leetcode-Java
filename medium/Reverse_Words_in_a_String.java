package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. Reverse Words in a String
 */

public class Reverse_Words_in_a_String {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            while (start < s.length() && s.charAt(start) == ' ') {
                start++;
            }
            if (start == s.length()) {
                break;
            }
            end = start + 1;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            words.add(s.substring(start, end));
            start = end;
        }

        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    // 二刷
    public String reverseWords_2(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        boolean isFirst = true;
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == ' ') {
                while (i >= start && s.charAt(i) == ' ') {
                    i--;
                }
                i++;
                if (!isFirst) {
                    sb.append(" ");
                }
                isFirst = false;
                sb.append(word);
                word.delete(0, word.length());
            } else {
                word.insert(0, s.charAt(i));
            }
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        sb.append(word);
        return sb.toString();
    }
}
