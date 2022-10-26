package medium;

/**
 * 80. Remove Duplicates from Sorted Array II
 */

public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (index < 2 || num > nums[index - 2]) {
                nums[index++] = num;
            }
        }
        return index;
    }
}
