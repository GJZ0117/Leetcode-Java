package medium;

/**
 * 1017. Convert to Base -2
 */

public class Convert_to_Base_2 {
    // https://leetcode.cn/problems/convert-to-base-2/solution/duan-chu-fa-pythonyi-xing-jin-shuang-bai-ch27/1983756
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        int k = -2;
        while (n != 0) {
            int remain = n % k;
            sb.insert(0, remain < 0 ? -k + remain : remain);
            n = remain < 0 ? n / k + 1 : n / k;
        }
        return sb.toString().isBlank() ? "0" : sb.toString();
    }
}
