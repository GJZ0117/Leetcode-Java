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

    // 二刷
    public String convert_2(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int lineIndex = 0;
        boolean addLineIndex = true;
        for (int i = 0; i < s.length(); i++) {
            stringBuilders[lineIndex].append(s.charAt(i));
            if (addLineIndex && lineIndex + 1 != numRows) {
                lineIndex++;
            } else if (lineIndex - 1 != -1) {
                lineIndex--;
            }
            if (lineIndex == numRows - 1) {
                addLineIndex = false;
            } else if (lineIndex == 0) {
                addLineIndex = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : stringBuilders) {
            res.append(sb);
        }
        return res.toString();
    }
}
