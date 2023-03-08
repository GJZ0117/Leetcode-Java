package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 922. Sort Array By Parity II
 */

public class Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] % 2 == 0) {
                list1.add(i);
            } else if (i % 2 == 0 && nums[i] % 2 == 1) {
                list2.add(i);
            }
        }
        while (list1.size() != 0) {
            int index1 = list1.get(0);
            int index2 = list2.get(0);
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
            list1.remove(0);
            list2.remove(0);
        }
        return nums;
    }
}
