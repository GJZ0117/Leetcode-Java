package easy;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 */

public class Move_Zeroes {

    public static void main(String[] args) {
        int[] nums = {1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int i;
        int index = 0;
        int zeroNum = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                nums[index] = nums[index + zeroNum];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }


    // 二刷
    public void moveZeroes_2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        for (int i = 0, index = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= nums.length - count; i--) {
            nums[i] = 0;
        }
    }
}
