package easy;

/**
 * 859. Buddy Strings
 */

public class Buddy_Strings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            b[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
            }
        }
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
            if (a[i] > 1) {
                flag = true;
            }
        }
        return diff == 2 || (diff == 0 && flag);
    }
}
