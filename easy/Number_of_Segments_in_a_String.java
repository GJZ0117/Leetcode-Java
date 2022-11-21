package easy;

/**
 * 434. Number of Segments in a String
 */

public class Number_of_Segments_in_a_String {
    public int countSegments(String s) {
        String[] strs = s.split(" ");
        int ans = 0;
        for (String str : strs) {
            if (str.length() > 0 && !" ".equals(str)) {
                ans++;
            }
        }
        return ans;
    }
}
