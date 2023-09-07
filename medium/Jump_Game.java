package medium;


/**
 * 55. Jump Game
 */

public class Jump_Game {

    public boolean canJump(int[] nums) {
        int furthest = 0;
        int i = 0;
        for (; i < nums.length && i <= furthest; i++) {
            furthest = Math.max(furthest, i + nums[i]);
        }
        return furthest >= nums.length - 1;
    }


    // 二刷
    public boolean canJump_2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex == i) {
                return false;
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
