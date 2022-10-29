package easy;

/**
 * 190. Reverse Bits
 */

public class Reverse_Bits {
    /**
     * every time left move result, and then put the end binary number of n at the end of result, lastly right move n
     * eg:  i       n           res
     *      -       11001001    -
     *      1       1100100     1
     *      2       110010      10
     *      3       11001       100
     *      4       1100        1001
     *      5       110         10010
     *      6       11          100100
     *      7       1           1001001
     *      8       -           10010011
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }
}
