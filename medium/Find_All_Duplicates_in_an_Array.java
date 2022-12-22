package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 */

public class Find_All_Duplicates_in_an_Array {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                    i--;
                }
            }
            System.out.println(Arrays.toString(nums));
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }

        return list;
    }
}
