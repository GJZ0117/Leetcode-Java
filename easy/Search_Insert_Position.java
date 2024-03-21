package easy;

/**
 * 35. Search Insert Position
 */

public class Search_Insert_Position {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        System.out.println(searchInsert(nums, -2));
    }

    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
//            if ((mid<nums.length-1 && nums[mid]<target && nums[mid+1]>target) || (mid>0 && nums[mid]<target && nums[mid+1]>target)) {
//                return mid+1;
//            }
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    // 二刷
    public int searchInsert_2(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        } else if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
