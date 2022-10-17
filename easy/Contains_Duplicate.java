package easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217. Contains Duplicate
 */

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }else {
                set.add(num);
            }
        }
        return false;
    }
}
