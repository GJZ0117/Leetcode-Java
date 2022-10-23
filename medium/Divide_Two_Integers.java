package medium;

/**
 * 29. Divide Two Integers
 */

public class Divide_Two_Integers {

    /**
     * https://leetcode.cn/problems/divide-two-integers/solution/gong-shui-san-xie-dui-xian-zhi-tiao-jian-utb9/
     */

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int limit = -1073741824; //half of Integer.MIN_VALUE
        boolean flag = false; // if the answer is negetive
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            flag = true;
        }

        //convert a and b to [Integer.MIN_VALUE, 0] (this range is larger than [0, Integer.MAX_VALUE])
        if (a > 0) {
            a = 0 - a;
        }
        if (b > 0) {
            b = 0 - b;
        }

        int ans = 0;

        while (a <= b) {
            int c = b;
            int d = -1;
            while (c >= limit && d >= limit && c >= a - c) {
                c += c;
                d += d;
            }
            a -= c;
            ans += d;
        }

        return flag ? ans : 0 - ans;
    }
}
