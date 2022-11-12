package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. Reverse Words in a String
 */

public class Reverse_Words_in_a_String {

    public static void main(String[] args) {
        String s =  "the sky is blue";
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
}
