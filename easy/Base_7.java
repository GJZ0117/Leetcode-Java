package easy;

/**
 * 504. Base 7
 */

public class Base_7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isPositive = num > 0;
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while (num != 0) {
            int cur = num % 7;
            num /= 7;
            sb.insert(0, cur);
        }
        return isPositive ? sb.toString() : "-" + sb.toString();
    }
}
