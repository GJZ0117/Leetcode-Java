package easy;

/**
 * 342. Power of Four
 */

public class Power_of_Four {
    public boolean isPowerOfFour(int n) {
        if (n >= 1) {
            while (n % 4 == 0) {
                n /= 4;
            }
        }
        return n == 1;
    }
}
