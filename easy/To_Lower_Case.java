package easy;

/**
 * 709. To Lower Case
 */

public class To_Lower_Case {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - 'A' >= 0 && c - 'Z' <= 0) {
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
