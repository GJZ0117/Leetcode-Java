package medium;

import java.util.Arrays;

/**
 * 324. Wiggle Sort II
 */

public class Wiggle_Sort_II {
    public void wiggleSort(int[] nums) {
        int[] help = nums.clone();
        Arrays.sort(help);
        int n = nums.length;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = help[--n];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = help[--n];
        }
    }
}
