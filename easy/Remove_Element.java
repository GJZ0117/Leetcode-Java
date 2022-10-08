package easy;

import java.util.Arrays;

/**
 * 27. Remove Element
 */

public class Remove_Element {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    //双指针i:0->n-1, j:n-1->0
    public static int removeElement(int[] nums, int val) {
        int duplication = 0;
        int temp;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < nums.length && nums[i] != val) {
                i++;
            }
            while (j >= 0 && nums[j] == val) {
                j--;
            }

            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        for (i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                duplication++;
            } else {
                break;
            }
        }
        return nums.length - duplication;
    }
}
