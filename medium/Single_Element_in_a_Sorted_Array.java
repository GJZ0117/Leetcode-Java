package medium;

/**
 * 540. Single Element in a Sorted Array
 */

public class Single_Element_in_a_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 0) {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return nums[end];
    }
}
