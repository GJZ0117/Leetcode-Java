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
        for (i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            }else {
                nums[index] = nums[index + zeroNum];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
