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

}
