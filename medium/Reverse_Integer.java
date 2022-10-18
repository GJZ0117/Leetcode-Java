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
        if (str.length() < compareValue.length()){
            return Integer.parseInt(str);
        }

        // reversed x length equals to max or min integer length, compare every character
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) - compareValue.charAt(i) > 0) {
                return 0;
            }else if (str.charAt(i) - compareValue.charAt(i) < 0) {
                return Integer.parseInt(str);
            }
        }
        return Integer.parseInt(str);
    }
}
