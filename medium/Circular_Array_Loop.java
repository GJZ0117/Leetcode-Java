package medium;

/**
 * 457. Circular Array Loop
 */

public class Circular_Array_Loop {
    // https://leetcode.cn/problems/circular-array-loop/solution/fu-xue-ming-zhu-dong-hua-ti-jie-kuai-man-ju4g/
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = next(nums, n, i);
            while (nums[fast] * nums[i] > 0 && nums[next(nums, n, fast)] * nums[i] > 0) {
                if (fast == slow) {
                    if (slow == next(nums, n, slow)) {
                        break;
                    }
                    return true;
                }
                slow = next(nums, n, slow);
                fast = next(nums, n, next(nums, n, fast));
            }
        }
        return false;
    }

    public int next(int[] nums, int n, int i) {
        return ((i + nums[i]) % n + n) % n;
    }
}
