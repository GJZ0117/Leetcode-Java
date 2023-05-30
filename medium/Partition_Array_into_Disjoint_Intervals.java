package medium;

import java.util.TreeMap;

/**
 * 915. Partition Array into Disjoint Intervals
 */

public class Partition_Array_into_Disjoint_Intervals {
    public int partitionDisjoint(int[] nums) {
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        for (int i = 1; i < nums.length; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }
        int leftMax = nums[0];
        int leftSize = 1;
        if (leftMax <= rightMap.firstKey()) {
            return leftSize;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            int curNum = nums[i];
            leftMax = Math.max(leftMax, curNum);
            leftSize++;
            if (rightMap.get(curNum) == 1) {
                rightMap.remove(curNum);
            } else {
                rightMap.put(curNum, rightMap.get(curNum) - 1);
            }
            if (leftMax <= rightMap.firstKey()) {
                break;
            }
        }
        return leftSize;
    }
}
