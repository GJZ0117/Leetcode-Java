package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 824. Goat Latin
 */

public class Goat_Latin {
    public String toGoatLatin(String sentence) {
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

        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (set.contains(str.charAt(0))) {
                temp.append(str);
            } else {
                temp.append(str.substring(1, str.length()));
                temp.append(str.charAt(0));
            }
            temp.append("ma");
            temp.append("a".repeat(i + 1));
            sb.append(temp);
            if (i != strs.length - 1) {
                sb.append(" ");
            }
            temp.delete(0, sb.length());
        }
        return sb.toString();
    }
}
