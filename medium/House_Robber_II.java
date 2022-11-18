package medium;

/**
 * 213. House Robber II
 */

public class House_Robber_II {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // rob first house and not rob last house
        int temp = nums[nums.length - 1];
        nums[nums.length - 1] = 0;
        int notRobLastHouse = robHouses(nums);
        nums[nums.length - 1] = temp;

        // not rob first house
        temp = nums[0];
        nums[0] = 0;
        int notRobFirstHouse = robHouses(nums);
        nums[0] = temp;

        return Math.max(notRobFirstHouse, notRobLastHouse);
    }

    // like leetcode problem 198
    public int robHouses(int[] nums) {
        int robPrevious = 0;
        int notRobPrevious = 0;
        for (int i = 0; i < nums.length; i++) {
            int robCurHouse = notRobPrevious + nums[i];
            int notRobCurHouse = Math.max(robPrevious, notRobPrevious);
            notRobPrevious = notRobCurHouse;
            robPrevious = robCurHouse;
        }
        return Math.max(notRobPrevious, robPrevious);
    }
}
