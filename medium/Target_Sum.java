package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum
 */

public class Target_Sum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(nums, target, 0, 0, map);
    }

    public int dfs(int[] nums, int target, int index, int cur, Map<String, Integer> map) {

        String key = index + "_" + cur;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (index == nums.length) {
            map.put(key, cur == target ? 1 : 0);
            return map.get(key);
        }

        int minus = dfs(nums, target, index + 1, cur - nums[index], map);
        int add = dfs(nums, target, index + 1, cur + nums[index], map);
        map.put(key, minus + add);

        return minus + add;
    }
}
