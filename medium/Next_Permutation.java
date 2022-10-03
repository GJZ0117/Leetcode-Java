package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 31. Next Permutation
 */

public class Next_Permutation {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
    }

    /*
    * https://leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia
    * Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
    * Find the largest index l > k such that nums[k] < nums[l].
    * Swap nums[k] and nums[l].
    * Reverse the sub-array nums[k + 1:].
    */

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int k, l;
        for (k = len - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        if (k < 0) {
            reverse(nums, 0, len - 1);
        } else {
            for (l = len - 1; l > k; l--) {
                if (nums[l] > nums[k]) {
                    break;
                }
            }
            swap(nums, k, l);
            reverse(nums, k + 1, len - 1);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void reverse(int[] nums, int begin, int end) {
        int temp;
        while (begin < end) {
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            ++begin;
            --end;
        }
    }
}
