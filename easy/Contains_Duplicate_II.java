package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 */

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        boolean flag;
        int i;
        for (i = 0; i < nums.length && i <= k; i++) {
            flag = set.add(nums[i]);
            if (!flag) {
                return true;
            }
        }

        for (; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            flag = set.add(nums[i]);
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}
