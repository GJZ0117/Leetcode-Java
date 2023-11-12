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


    // 二刷
    public int trailingZeroes_2(int n) {
        int res = 0;
        while (n > 0) {
            res += (n / 5);
            n /= 5;
        }
        return res;
    }
}
