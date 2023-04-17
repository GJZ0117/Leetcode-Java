package medium;

/**
 * 831. Masking Personal Information
 */

public class Masking_Personal_Information {
    public String maskPII(String s) {
        boolean flag = s.contains("@");
        if (flag) {
            String[] strs = s.split("@");
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toLowerCase(strs[0].charAt(0)));
            sb.append("*****");
            sb.append(Character.toLowerCase(strs[0].charAt(strs[0].length() - 1)));
            sb.append("@");
            for (char c : strs[1].toCharArray()) {
                if (c == '.') {
                    sb.append(c);
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            int len = sb.length();
            sb.delete(0, sb.length() - 4);
            sb.insert(0, "***-***-");
            if (len == 10) {
                return sb.toString();
            } else {
                sb.insert(0, "-");
                for (int i = 0; i < len - 10; i++) {
                    sb.insert(0, "*");
                }
                sb.insert(0, "+");
                return sb.toString();
            }
        }
    }
}
