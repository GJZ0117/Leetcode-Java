package medium;

/**
 * 260. Single Number III
 */

public class Single_Number_III {
    //https://leetcode.cn/problems/single-number-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-zgi4/
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        int k = -1;
        for (int i = 31; i >= 0 && k == -1; i--) {
            if (((sum >> i) & 1) == 1) {
                k = i;
            }
        }

        int[] ans = new int[2];
        for (int num : nums) {
            if (((num >> k) & 1) == 1) {
                ans[0] = ans[0] ^ num;
            } else {
                ans[1] = ans[1] ^ num;
            }
        }
        return ans;
    }
}
