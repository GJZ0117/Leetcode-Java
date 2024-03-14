package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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


    // 二刷
    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
