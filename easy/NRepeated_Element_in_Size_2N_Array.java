package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 961. N-Repeated Element in Size 2N Array
 */

public class NRepeated_Element_in_Size_2N_Array {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean flag = set.add(num);
            if (!flag) {
                return num;
            }
        }
        return 0;
    }
}
