package medium;

/**
 * 264. Ugly Number II
 */

public class Ugly_Number_II {
    //https://leetcode.cn/problems/ugly-number-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-you-x-3nvs/
    public int nthUglyNumber(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        for (int i2 = 1, i3 = 1, i5 = 1, index = 2; index <= n; index++) {
            int a = ans[i2] * 2;
            int b = ans[i3] * 3;
            int c = ans[i5] * 5;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) {
                i2++;
            }
            if (min == b) {
                i3++;
            }
            if (min == c) {
                i5++;
            }
            ans[index] = min;
        }
        return ans[n];
    }
}
