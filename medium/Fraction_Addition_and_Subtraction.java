package medium;

/**
 * 592. Fraction Addition and Subtraction
 */

public class Fraction_Addition_and_Subtraction {
    public String fractionAddition(String expression) {
        long up1 = 0;
        long down1 = 1;
        int i = 0;
        while (i < expression.length()) {
            long up2 = 0;
            long down2 = 0;
            boolean flag = true;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                flag = expression.charAt(i) == '+';
                i++;
            }
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                up2 = up2 * 10 + expression.charAt(i) - '0';
                i++;
            }
            up2 = flag ? up2 : -1 * up2;
            i++;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                down2 = down2 * 10 + expression.charAt(i) - '0';
                i++;
            }
            up1 = up1 * down2 + up2 * down1;
            down1 = down1 * down2;
        }

        if (up1 != 0) {
            long n = Math.abs(gcd(down1, up1));
            down1 = down1 / n;
            up1 = up1 / n;
        } else {
            down1 = 1;
        }
        return up1 + "/" + down1;
    }

    public long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }
}
