package medium;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 775. Global and Local Inversions
 */

public class Global_and_Local_Inversions {
    public boolean isIdealPermutation(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() > nums[i] && entry.getValue() != i - 1) {
                    return false;
                } else if (entry.getKey() < nums[i]) {
                    break;
                }
            }
            map.put(nums[i], i);
        }
        return true;
    }
}
