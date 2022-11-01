package medium;

/**
 * 189. Rotate Array
 */

public class Rotate_Array {

    public void betterSolution(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //Time Limit Exceeded
    public static void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0) {
            return;
        }
        k %= nums.length;
        while (k > 0) {
            rightMoveOne(nums);
            k--;
        }
    }

    public static void rightMoveOne(int[] nums) {
        int lastNum = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = lastNum;
    }
}
