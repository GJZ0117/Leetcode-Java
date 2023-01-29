package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 565. Array Nesting
 */

public class Array_Nesting {
    public int arrayNesting(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;
        for (int num : nums) {
            int curCount = 0;
            if (!set.contains(num)) {
                set.add(num);
                curCount++;
                int index = num;
                while (!set.contains(nums[index])) {
                    set.add(nums[index]);
                    curCount++;
                    index = nums[index];
                }
            }
            maxCount = Math.max(maxCount, curCount);
        }
        return maxCount;
    }
}
