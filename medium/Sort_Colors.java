package medium;


/**
 * 75. Sort Colors
 */

public class Sort_Colors {

    public void sortColors(int[] nums) {
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

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    // 二刷(还不会)
    public void sortColors_2(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }
}
