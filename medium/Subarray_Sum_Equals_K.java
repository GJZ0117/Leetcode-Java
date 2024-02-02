package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 */

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public int _subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }


    // 二刷
    public int subarraySum_2(int[] nums, int k) {
        int ans = 0;
        int curSum = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (preSumMap.containsKey(curSum - k)) {
                ans += preSumMap.get(curSum - k);
            }
            preSumMap.put(curSum, preSumMap.getOrDefault(curSum, 0) + 1);
        }
        return ans;
    }
}
