package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 648. Replace Words
 */

public class Replace_Words {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            boolean isFound = false;
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.substring(0, i + 1))) {
                    sb.append(str, 0, i + 1);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                sb.append(str);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
