package easy;

/**
 * 14. Longest Common Prefix
 */

public class Longest_Common_Prefix {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        char cur;
        boolean flag = true;
        int minLen = 200;
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }
        for (int i = 0; i < minLen && flag; i++) {
            cur = strs[0].charAt(i);
            sb.append(cur);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != cur) {
                    flag = false;
                    sb.delete(sb.length() - 1, sb.length());
                    break;
                }
            }
        }
        return sb.toString();
    }
}
