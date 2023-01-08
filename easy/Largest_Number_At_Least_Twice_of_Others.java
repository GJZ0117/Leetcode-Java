package easy;

/**
 * 747. Largest Number At Least Twice of Others
 */

public class Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] nums) {
        int index = 0;
        Integer n1 = nums[0];
        Integer n2 = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > n1) {
                index = i;
                n2 = n1;
                n1 = nums[i];
            } else if (n2 == null || nums[i] > n2) {
                n2 = nums[i];
            }
        }
        if (n1 >= 2 * n2) {
            return index;
        } else {
            return -1;
        }
    }
}
