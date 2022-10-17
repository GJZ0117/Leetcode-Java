package medium;

/**
 * 6. Zigzag Conversion
 */

public class Zigzag_Conversion {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0; //use i as an index to traverse string s
        while (i < len) {
            for (int row = 0; row < numRows && i < len; i++, row++) { //from up to down
                sb[row].append(s.charAt(i));
            }
            for (int row = numRows - 2; row >= 1 && i < len; i++, row--) { //from down to up
                sb[row].append(s.charAt(i));
            }
        }
        for (int row = 1; row < numRows; row++) { //append all stringBuilder to sb[0]
            sb[0].append(sb[row]);
        }
        return sb[0].toString();
    }
}
