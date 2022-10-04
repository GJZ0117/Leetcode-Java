package easy;

/**
 * 392. Is Subsequence
 */

public class Is_Subsequence {

    public static void main(String[] args) {
        String s = "axc";
        String t = "akhbwec";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = 0;
        boolean flag = false;
        while (i < s.length()) {
            flag = false;
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    flag = true;
                    j++;
                    break;
                }
                j++;
            }
            i++;
        }
        if (flag == true && i == s.length()) {
            return true;
        }
        return false;
    }

}
