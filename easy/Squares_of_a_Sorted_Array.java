package easy;

/**
 * 977. Squares of a Sorted Array
 */

public class Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int startIndex = nums.length - 1;
        if (nums[0] >= 0) {
            startIndex = 0;
        } else {
            for (int index = 0; index < nums.length; index++) {
                if (Math.abs(nums[index]) < Math.abs(nums[startIndex])) {
                    startIndex = index;
                }
            }
        }
        int i = startIndex;
        int j = startIndex + 1;
        int k = 0;
        while (i >= 0 && j < nums.length) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                i--;
                k++;
            } else {
                ans[k] = nums[j] * nums[j];
                j++;
                k++;
            }
        }

        if (i >= 0) {
            while (i >= 0) {
                ans[k] = nums[i] * nums[i];
                i--;
                k++;
            }
        } else {
            while (j < nums.length) {
                ans[k] = nums[j] * nums[j];
                j++;
                k++;
            }
        }
        return ans;
    }


    // 二刷
    public int[] sortedSquares_2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int left2 = nums[left] * nums[left];
            int right2 = nums[right] * nums[right];
            if (left2 < right2) {
                ans[i] = right2;
                right--;
            } else {
                ans[i] = left2;
                left++;
            }
        }
        return ans;
    }
}
