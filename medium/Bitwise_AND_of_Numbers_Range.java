package medium;

/**
 * 201. Bitwise AND of Numbers Range
 */

public class Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        right <<= count;
        return right;
    }


    // 二刷（还不会）
    // 找公共前缀
    public int rangeBitwiseAnd_2(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return right << count;
    }
}
