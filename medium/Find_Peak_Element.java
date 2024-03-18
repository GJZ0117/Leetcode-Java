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


    // 二刷（还不会）
    public int findPeakElement_2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
        }
        return -1;
    }


    // 三刷
    public int findPeakElement_3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
