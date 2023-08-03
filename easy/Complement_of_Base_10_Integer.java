package easy;

/**
 * 1009. Complement of Base 10 Integer
 */

public class Complement_of_Base_10_Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        double res = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n & 1);
            n = n >> 1;
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            res = res + (sb.charAt(i) == '0' ? Math.pow(2, sb.length() - 1 - i) : 0);
        }
        return (int) res;
    }
}
