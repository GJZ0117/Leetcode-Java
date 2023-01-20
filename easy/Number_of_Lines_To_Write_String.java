package easy;

/**
 * 806. Number of Lines To Write String
 */

public class Number_of_Lines_To_Write_String {
    public int[] numberOfLines(int[] widths, String s) {
        int remain = 100;
        int line = 1;
        for (char c : s.toCharArray()) {
            int length = widths[c - 'a'];
            if (remain >= length) {
                remain -= length;
            } else {
                line++;
                remain = 100;
                remain -= length;
            }
        }
        return new int[]{line, 100 - remain};
    }
}
