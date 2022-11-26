package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 */

public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
