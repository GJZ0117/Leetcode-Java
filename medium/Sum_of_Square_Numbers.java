package medium;

/**
 * 633. Sum of Square Numbers
 */

public class Sum_of_Square_Numbers {
    // https://leetcode.cn/problems/sum-of-square-numbers/solution/shuang-zhi-zhen-de-ben-zhi-er-wei-ju-zhe-ebn3/
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (int) Math.sqrt(c);
        while (low <= high) {
            long sum = low * low + high * high;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
