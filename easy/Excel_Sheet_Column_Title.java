package easy;

/**
 * 168. Excel Sheet Column Title
 */

public class Excel_Sheet_Column_Title {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + (columnNumber % 26)));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
