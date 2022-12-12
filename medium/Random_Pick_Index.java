package medium;

import java.util.*;

/**
 * 398. Random Pick Index
 */

public class Random_Pick_Index {
    class Solution {
        private Map<Integer, List<Integer>> map = new HashMap<>();
        Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.get(nums[i]).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i], list);
                }
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }
}
