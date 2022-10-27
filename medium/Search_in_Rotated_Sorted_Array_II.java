package medium;

/**
 * 81. Search in Rotated Sorted Array II
 */

public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < nums[high] || nums[mid] < nums[low]) { //right side is sorted or left side is unsorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > nums[low] || nums[mid] > nums[high]) { //left side is sorted or right side is unsorted
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //nums[start] == nums[mid] == nums[end]
                high--; //or low++ is ok
            }
        }
        return false;
    }
}
