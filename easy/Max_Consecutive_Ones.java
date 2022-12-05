package easy;

import java.util.Arrays;

/**
 * 485. Max Consecutive Ones
 */

public class Max_Consecutive_Ones {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && start == -1) {
                start = i;
                end = i;
            } else if (nums[i] == 1 && start != -1) {
                end = i;
            } else if (nums[i] == 0 && start != -1) {
                maxLen = Math.max(maxLen, end - start + 1);
                start = -1;
            }
        }
        if (start != -1) {
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
