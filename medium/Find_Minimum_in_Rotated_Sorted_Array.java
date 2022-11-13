package medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */

public class Find_Minimum_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(findMin(nums));
    }

    //https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            System.out.println(left + " " + right + " " + mid);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}
