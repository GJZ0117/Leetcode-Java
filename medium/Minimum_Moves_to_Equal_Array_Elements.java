package medium;

/**
 * 453. Minimum Moves to Equal Array Elements
 */

public class Minimum_Moves_to_Equal_Array_Elements {
    public int minMoves(int[] nums) {
        int count = 0;
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
        }

        for (int num : nums) {
            count += (num - minValue);
        }
        return count;
    }
}
