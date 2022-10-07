package easy;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 */

public class Remove_Duplicates_from_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int duplication = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                duplication++;
            } else {
                nums[i - duplication] = nums[i];
            }
        }
        return nums.length - duplication;
    }
}
