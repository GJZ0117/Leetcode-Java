package medium;

import java.util.Arrays;

/**
 * 75. Sort Colors
 */

public class Sort_Colors {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        for (int cur = 0; cur <= j; ) {
            if (nums[cur] == 0) {
                swap(nums, cur, i);
                cur++;
                i++;
            } else if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, j);
                j--;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
