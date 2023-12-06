package medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. Ugly Number II
 */

public class Ugly_Number_II {
    //https://leetcode.cn/problems/ugly-number-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-you-x-3nvs/
    public int nthUglyNumber(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        for (int i2 = 1, i3 = 1, i5 = 1, index = 2; index <= n; index++) {
            int a = ans[i2] * 2;
            int b = ans[i3] * 3;
            int c = ans[i5] * 5;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) {
                i2++;
            }
            if (min == b) {
                i3++;
            }
            if (min == c) {
                i5++;
            }
            ans[index] = min;
        }
        return ans[n];
    }


    // 二刷（还不会）
    public int nthUglyNumber_2(int n) {
        int[] nums = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        set.add(1L);
        priorityQueue.add(1L);
        for (int i = 1; i <= n; i++) {
            long x = priorityQueue.poll();
            if (i == n) {
                return (int) x;
            }
            for (int num : nums) {
                long cur = num * x;
                if (!set.contains(cur)) {
                    set.add(cur);
                    priorityQueue.add(cur);
                }
            }
        }
        return -1;
    }
}
