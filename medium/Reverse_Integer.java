package medium;

/**
 * 7. Reverse Integer
 */

public class Reverse_Integer {

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(); //store reversed x

        if (x < 0) {
            sb.append('-');
        }

        while (x % 10 == 0) { // if x is ended with 0, then clear all the 0 at the end of x
            x /= 10;
        }

        while (x != 0) { //reverse x
            sb.append(Math.abs(x % 10));
            x /= 10;
        }

        String str = sb.toString();

        //check after reversed, if x is over -2^31 or 2^31-1
        String compareValue = "" + (str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE);

        // reversed x length is shorter than max or min integer, return it directly
        if (str.length() < compareValue.length()) {
            return Integer.parseInt(str);
        }

        // reversed x length equals to max or min integer length, compare every character
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - compareValue.charAt(i) > 0) {
                return 0;
            } else if (str.charAt(i) - compareValue.charAt(i) < 0) {
                return Integer.parseInt(str);
            }
        }
        return Integer.parseInt(str);
    }

    // 二刷
    public int reverse_2(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = x > 0;
        x = Math.abs(x);
        StringBuilder sb = new StringBuilder();
        boolean firstZero = true;
        while (x != 0) {
            int cur = x % 10;
            if (firstZero && cur == 0) {
                x = x / 10;
                continue;
            } else {
                firstZero = false;
                sb.append(cur);
                x = x / 10;
            }
        }
        String res = flag ? sb.toString() : sb.insert(0, '-').toString();
        String maxInt = String.valueOf(Integer.MAX_VALUE);
        String minInt = String.valueOf(Integer.MIN_VALUE);
        if ((flag && res.length() >= maxInt.length() && res.compareTo(maxInt) > 0) || (!flag && res.length() >= minInt.length() && res.compareTo(minInt) > 0)) {
            return 0;
        }
        return Integer.parseInt(res);
    }
}
