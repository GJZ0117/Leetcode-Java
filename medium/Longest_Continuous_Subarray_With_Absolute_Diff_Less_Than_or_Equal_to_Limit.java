package medium;

import java.util.TreeMap;

/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < nums.length) {

            int rightNum = nums[right];
            right++;
            map.put(rightNum, map.getOrDefault(rightNum, 0) + 1);

            if (rightNum < map.firstKey()) {
                if (Math.abs(rightNum - map.lastKey()) > limit) {
                    while (left < right && !map.isEmpty()) {
                        int leftNum = nums[left];
                        left++;
                        map.put(leftNum, map.get(leftNum) - 1);
                        if (map.get(leftNum) == 0) {
                            map.remove(leftNum);
                        }
                        if (Math.abs(rightNum - map.lastKey()) <= limit) {
                            break;
                        }
                    }
                }
            } else if (rightNum > map.lastKey()) {
                if (Math.abs(rightNum - map.firstKey()) > limit) {
                    while (left < right && !map.isEmpty()) {
                        int leftNum = nums[left];
                        left++;
                        map.put(leftNum, map.get(leftNum) - 1);
                        if (map.get(leftNum) == 0) {
                            map.remove(leftNum);
                        }
                        if (Math.abs(rightNum - map.firstKey()) <= limit) {
                            break;
                        }
                    }
                }
            } else {
                if (Math.abs(rightNum - map.firstKey()) > limit || Math.abs(rightNum - map.lastKey()) > limit) {
                    while (left < right && !map.isEmpty()) {
                        int leftNum = nums[left];
                        left++;
                        map.put(leftNum, map.get(leftNum) - 1);
                        if (map.get(leftNum) == 0) {
                            map.remove(leftNum);
                        }
                        if (Math.abs(rightNum - map.firstKey()) <= limit && Math.abs(rightNum - map.lastKey()) <= limit) {
                            break;
                        }
                    }
                }
            }
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
