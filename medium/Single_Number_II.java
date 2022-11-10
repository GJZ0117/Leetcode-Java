package medium;

/**
 * 137. Single Number II
 */

public class Single_Number_II {
    //https://leetcode.cn/problems/single-number-ii/solution/ti-yi-lei-jie-wei-yun-suan-yi-wen-dai-ni-50dc/
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += ((num >> i) & 1);
            }
            if (sum % 3 == 1) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
