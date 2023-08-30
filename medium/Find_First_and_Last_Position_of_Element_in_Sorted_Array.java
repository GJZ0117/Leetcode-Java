package medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int len = nums.length;
        if (nums.length == 0 || target > nums[len - 1] || target < nums[0]) {
            return res;
        }
        int low = 0;
        int high = len - 1;
        //search for the left one
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (nums[low] != target) {
            return res;
        } else {
            res[0] = low;
        }

        high = len - 1;

        //search for the right one
        while (low < high) {
            int mid = (low + high) / 2 + 1; //make mid biased to the right
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        res[1] = high;
        return res;
    }


    // 二刷(还不会)
    // https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/1980196/er-fen-cha-zhao-zong-shi-xie-bu-dui-yi-g-t9l9/
    public int[] searchRange_2(int[] nums, int target) {
        int low = lowBound(nums, target);
        if (low == nums.length || nums[low] != target) {
            return new int[]{-1, -1};
        }
        int high = lowBound(nums, target + 1) - 1;
        return new int[]{low, high};
    }

    private int lowBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
