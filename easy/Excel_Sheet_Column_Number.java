package easy;

/**
 * 171. Excel Sheet Column Number
 */

public class Excel_Sheet_Column_Number {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int times = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char curChar = columnTitle.charAt(i);
            int curNum = (int) (Math.pow(26, times) * (curChar - 'A' + 1));
            ans += curNum;
            times++;
        }
        return ans;
    }
}
