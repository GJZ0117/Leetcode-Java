package medium;

/**
 * 172. Factorial Trailing Zeroes
 */

public class Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int zeroNum = 0;
        while (n > 0) {
            zeroNum += n / 5;
            n /= 5;
        }
        return zeroNum;
    }
}
