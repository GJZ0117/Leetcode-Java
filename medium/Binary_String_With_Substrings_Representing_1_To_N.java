package medium;

/**
 * 1016. Binary String With Substrings Representing 1 To N
 */

public class Binary_String_With_Substrings_Representing_1_To_N {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
