package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 */

public class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !set.contains(chars[i])) {
                i++;
            }
            while (i < j && !set.contains(chars[j])) {
                j--;
            }
            if (i < j && chars[i] != chars[j]) {
                swap(chars, i, j);
            }
            i++;
            j--;
        }

        return String.valueOf(chars);
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
