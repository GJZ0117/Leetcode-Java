package easy;

/**
 * 326. Power of Three
 */

public class Power_of_Three {
    public boolean isPowerOfThree(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }
}
