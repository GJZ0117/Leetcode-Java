package medium;

/**
 * 984. String Without AAA or BBB
 */

public class String_Without_AAA_or_BBB {
    public String strWithout3a3b(int a, int b) {
        int i = Math.max(a, b);
        int j = Math.min(a, b);
        boolean ab = false;
        if (a >= b) {
            ab = true;
        }
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            if (i > 2 && j == 0) {
                break;
            }
            if (i >= 2) {
                sb.append(ab ? "aa" : "bb");
                i = i - 2;
            } else {
                sb.append(ab ? "a" : "b");
                i = 0;
            }
            if (j >= 2 && i < j) {
                sb.append(ab ? "bb" : "aa");
                j = j - 2;
            } else if (j > 0) {
                sb.append(ab ? "b" : "a");
                j--;
            }
        }
        return sb.toString();
    }
}
