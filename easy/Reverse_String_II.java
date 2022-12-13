package easy;

/**
 * 541. Reverse String II
 */

public class Reverse_String_II {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k >= s.length()) {
                reverse(sb, s.substring(i));
            } else if (i + 2 * k >= s.length()) {
                reverse(sb, s.substring(i, i + k));
                sb.append(s.substring(i + k));
            } else {
                reverse(sb, s.substring(i, i + k));
                sb.append(s.substring(i + k, i + 2 * k));
            }
        }
        return sb.toString();
    }

    public void reverse(StringBuilder sb, String subStr) {
        for (int i = subStr.length() - 1; i >= 0; i--) {
            sb.append(subStr.charAt(i));
        }
    }
}
