package medium;

/**
 * 848. Shifting Letters
 */

public class Shifting_Letters {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder(s.length());
        long[] offset = new long[s.length() + 1];
        for (int i = shifts.length - 1; i >= 0; i--) {
            offset[i] = offset[i + 1] + shifts[i];
        }
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            int curOffset = (int) (offset[i] % 26);
            sb.append((char) ('a' + (cur + curOffset) % 26));
        }
        return sb.toString();
    }
}
