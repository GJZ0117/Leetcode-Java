package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 */

public class Contiguous_Array {
    // https://leetcode.cn/problems/contiguous-array/solution/dong-tu-yan-shi-qian-zhui-he-si-xiang-by-z2no/
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                --cur;
            } else {
                ++cur;
            }

            if (map.containsKey(cur)) {
                ans = Math.max(ans, i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }
        return ans;
    }
}
