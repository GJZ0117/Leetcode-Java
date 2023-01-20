package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 */

public class Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return set.size();
    }
}
