package easy;

/**
 * 724. Find Pivot Index
 */

public class Find_Pivot_Index {

    public static void main(String[] args) {
        int[] nums = {2, 1, -1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }


    // 二刷
    public int pivotIndex_2(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum == total - preSum - nums[i]) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}
