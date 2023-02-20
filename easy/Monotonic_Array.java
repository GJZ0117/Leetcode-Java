package easy;

/**
 * 896. Monotonic Array
 */

public class Monotonic_Array {
    public boolean isMonotonic(int[] nums) {
        boolean isAdd = true;
        boolean isMinus = true;
        for (int i = 1; i < nums.length; i++) {
            if ((!isAdd) && (!isMinus)) {
                break;
            }
            if (nums[i] < nums[i - 1]) {
                isAdd = false;
            } else if (nums[i] > nums[i - 1]) {
                isMinus = false;
            }
        }
        return isAdd || isMinus;
    }
}
