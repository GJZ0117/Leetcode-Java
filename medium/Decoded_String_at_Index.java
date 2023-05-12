package medium;

/**
 * 880. Decoded String at Index
 */

public class Decoded_String_at_Index {
    // https://leetcode.cn/problems/decoded-string-at-index/solution/suo-yin-chu-de-jie-ma-zi-fu-chuan-zheng-1iffv/
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        for (int i = 0; i < s.length(); i++) {
            long add = Character.isLetter(s.charAt(i)) ? 1 : (s.charAt(i) - '1') * len;
            if (len + add < k) {
                len += add;
            } else {
                if (len + add == k || k % len == 0) {
                    while (Character.isDigit(s.charAt(i))) {
                        i--;
                    }
                    return String.valueOf(s.charAt(i));
                }
                return decodeAtIndex(s.substring(0, i), (int) (k % len));
            }
        }
        return "";
    }
}
