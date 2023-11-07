package medium;

import java.util.TreeSet;

/**
 * 164. Maximum Gap
 */

public class Maximum_Gap {
    public int maximumGap(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxGap = 0;
        int prev = set.first();
        for (int num : set) {
            maxGap = Math.max(maxGap, num - prev);
            prev = num;
        }
        return maxGap;
    }
}
