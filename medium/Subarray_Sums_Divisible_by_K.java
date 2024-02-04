package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. Subarray Sums Divisible by K
 */

public class Subarray_Sums_Divisible_by_K {
    // https://leetcode.cn/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-kzheng-chu-de-zi-shu-zu-by-lenn123/
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        int[] arr = new int[k];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum + nums[i - 1];
            int key = (sum % k + k) % k;
            ans += arr[key];
            arr[key]++;
        }
        return ans;
    }


    // 二刷
    public int subarraysDivByK_2(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int curSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = (curSum + nums[i]) % k;
            if (curSum < 0) {
                curSum += k;
            }
            if (preSumMap.containsKey(curSum)) {
                ans += preSumMap.get(curSum);
            }
            preSumMap.put(curSum, preSumMap.getOrDefault(curSum, 0) + 1);
        }
        return ans;
    }
}
