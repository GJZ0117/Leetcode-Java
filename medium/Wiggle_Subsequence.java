package medium;

/**
 * 376. Wiggle Subsequence
 */

public class Wiggle_Subsequence {

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(nums));
    }

    //https://leetcode.cn/problems/wiggle-subsequence/solution/-by-xun-ge-v-nh8y/

    //use all numbers to paint a line graph,and find all /\ and \/ in graph (the first number should be included)
    public static int wiggleMaxLength(int[] nums) {
        int preDiff = 0;
        int curDiff = 0;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                maxLength++;
                preDiff = curDiff;
            }
        }
        return maxLength;
    }

    // 二刷（还不会）
    // https://leetcode.cn/problems/wiggle-subsequence/solutions/284327/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/
    public int wiggleMaxLength_2(int[] nums) {
        int down = 1;
        int up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
