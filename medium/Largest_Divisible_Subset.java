package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 */

public class Largest_Divisible_Subset {
    // https://leetcode.cn/problems/largest-divisible-subset/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-0a3jc/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // record when traverse each number, the maxium size of subset it can reach
        int[] dp = new int[nums.length];
        // when each number reaches its maxium subset, record its previous number's index which showed in its maxium subset
        int[] prev = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // the maxium subset at least contains one number (current number itself)
            int len = 1;
            int pre = i;
            // traverse those number which is smaller than current number, find if current number can divide them exactly
            for (int j = 0; j < i; j++) {
                // num[i] can divide num[j] exactly
                if (nums[i] % nums[j] == 0) {
                    // if num[j]'s maxium subset's size + 1 is larger than num[i]'s maxium subset's size, update variable len and pre
                    if (dp[j] + 1 > len) {
                        len = dp[j] + 1;
                        pre = j;
                    }
                }
            }
            // update dp[] and prev[]
            dp[i] = len;
            prev[i] = pre;
        }

        // find the maxium size and its index of subset which these numbers can reach
        int max = 0;
        int index = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        // record the maxium subset from back to front
        List<Integer> ans = new LinkedList<>();
        while (ans.size() != max) {
            ans.add(nums[index]);
            index = prev[index];
        }
        return ans;
    }
}
