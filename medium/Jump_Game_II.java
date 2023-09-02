package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 45. Jump Game II
 */

public class Jump_Game_II {

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    /**
     * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:
     */
    public int betterSolution(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFurthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFurthest = Math.max(curFurthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFurthest;
            }
        }
        return jumps;
    }

    //该方法超时
    public static int jump(int[] nums) {
        //list第一位表示curJumpTimes，第二位表示minJumpTimes
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1000);
        generate(nums, 0, list);
        return list.get(1);
    }

    public static void generate(int[] nums, int curIndex, List<Integer> list) {
        if (curIndex > nums.length - 1) {
            return;
        } else if (curIndex == nums.length - 1) {
            if (list.get(0) < list.get(1)) {
                list.set(1, list.get(0));
            }
            return;
        }
        list.set(0, list.get(0) + 1);
        for (int i = nums[curIndex]; i >= 1; i--) {
            if (list.get(0) > list.get(1)) {
                break;
            } else if (i + curIndex > nums.length - 1) {
                continue;
            }
            generate(nums, curIndex + i, list);
        }
        list.set(0, list.get(0) - 1);
    }


    // 二刷
    public int jump_2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
