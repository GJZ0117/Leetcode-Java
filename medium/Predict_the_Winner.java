package medium;

/**
 * 486. Predict the Winner
 */

public class Predict_the_Winner {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 0, 0, 1);
    }

    public boolean dfs(int[] nums, int left, int right, int score1, int score2, int player) {
        if (left > right) {
            return score1 >= score2;
        }

        if (player == 1) {
            if (dfs(nums, left + 1, right, score1 + nums[left], score2, 2)) {
                return true;
            }
            if (dfs(nums, left, right - 1, score1 + nums[right], score2, 2)) {
                return true;
            }
            return false;
        } else {
            if (!dfs(nums, left + 1, right, score1, score2 + nums[left], 1)) {
                return false;
            }
            if (!dfs(nums, left, right - 1, score1, score2 + nums[right], 1)) {
                return false;
            }
            return true;
        }
    }
}
