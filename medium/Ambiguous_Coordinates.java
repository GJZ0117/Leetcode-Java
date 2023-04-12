package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. Ambiguous Coordinates
 */

public class Ambiguous_Coordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();

        for (int i = 1; i < s.length(); i++) {
            for (String left : generate(s, 0, i)) {
                for (String right : generate(s, i, s.length())) {
                    ans.add(String.format("(%s, %s)", left, right));
                }
            }
        }
        return ans;
    }

    public List<String> generate(String s, int start, int end) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= end - start; i++) {
            String left = s.substring(start, start + i);
            String right = s.substring(start + i, end);
            boolean flag = ("0".equals(left) || !left.startsWith("0")) && !right.endsWith("0");
            if (flag) {
                ans.add(left + (i < end - start ? "." : "") + right);
            }
        }
        return ans;
    }
}
