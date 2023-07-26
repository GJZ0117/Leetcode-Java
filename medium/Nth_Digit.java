package medium;

/**
 * 400. Nth Digit
 */

public class Nth_Digit {
    public int findNthDigit(int n) {
        int cur = 1;
        int base = 9;
        while (cur * base < n) {
            n -= cur * base;
            cur++;
            base *= 10;
            if (Integer.MAX_VALUE / base < cur) {
                break;
            }
        }
        n--;
        int num = (int) Math.pow(10, cur - 1) + n / cur;
        int idx = n % cur;
        return num / (int) Math.pow(10, cur - 1 - idx) % 10;
    }
}
