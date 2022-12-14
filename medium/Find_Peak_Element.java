package medium;

/**
 * 162. Find Peak Element
 */

public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int[] ans = {-1};
        search(nums, 0, nums.length - 1, ans);
        return ans[0];
    }

    public boolean search(int[] nums, int start, int end, int[] ans) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if ((mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) || (mid == 0 && nums[mid] > nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] > nums[mid - 1])) {
            ans[0] = mid;
            return true;
        } else {
            boolean left = search(nums, start, mid - 1, ans);
            if (left) {
                return true;
            }
            boolean right = search(nums, mid + 1, end, ans);
            if (right) {
                return true;
            }
        }
        return false;
    }
}
