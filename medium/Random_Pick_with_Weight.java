package medium;

import java.util.Random;

/**
 * 528. Random Pick with Weight
 */

public class Random_Pick_with_Weight {
    class Solution {

        Random random;
        int sum;
        int[] dp;

        public Solution(int[] w) {
            random = new Random();
            dp = new int[w.length];
            dp[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                dp[i] = w[i] + dp[i - 1];
            }
            sum = dp[w.length - 1];
        }

        public int pickIndex() {
//            int num = random.nextInt(1, sum + 1); // Leetcode中AC,但IDEA中编译报错
            int num = 0; // 提交时删除这句用上面的代替
            for (int i = dp.length - 2; i >= 0; i--) {
                if (num > dp[i]) {
                    return i + 1;
                }
            }
            return 0;
        }
    }
}
