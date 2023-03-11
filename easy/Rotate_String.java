package easy;

/**
 * 796. Rotate String
 */

public class Rotate_String {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        while (len > 0) {
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            if (goal.equals(sb.toString())) {
                return true;
            }
            len--;
        }
        return false;
    }
}
